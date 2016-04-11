/*
 * Copyright 2012, Scott Douglass <scott@swdouglass.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * on the World Wide Web for more details:
 * http://www.fsf.org/licensing/licenses/gpl.txt
 */

package com.spacepirates.ldapservice;

import com.spacepirates.ldapservice.entities.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.directory.SearchControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.odm.core.OdmManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author Scott Douglass
 */
@Component
public class ContactLdapDAO implements ContactDAO {

  @Autowired private LdapContextSource ldapContextSource;
  @Autowired private OdmManager odmManager;

  private static final Logger LOG = Logger.getLogger(ContactLdapDAO.class.getName());

  //http://java.sun.com/products/jndi/1.2/javadoc/javax/naming/directory/SearchControls.html
  private static final SearchControls SEARCH_CONTROLS =
    new SearchControls(
      SearchControls.SUBTREE_SCOPE, 1000, 10000, null, true, false);


  @Override
  public List<Contact> getContacts() {
    final String userDn =
      this.ldapContextSource.getAuthenticationSource().getPrincipal();
    final List<Contact> contacts = new ArrayList<Contact>();
    contacts.addAll(getOdmManager().search(Contact.class,
      new DistinguishedName(userDn),
        "objectClass=*",SEARCH_CONTROLS));
    return contacts;
  }

  @Override
  public Contact get(final String contactId) {
    Contact con = null;
    final String userDn =
      this.ldapContextSource.getAuthenticationSource().getPrincipal();
    final List<Contact> contacts = new ArrayList<Contact>();
    contacts.addAll(getOdmManager().search(Contact.class,
      new DistinguishedName(userDn),
      "(&(objectClass=*)(uid=" + contactId +"))",SEARCH_CONTROLS));
    if (!contacts.isEmpty()) {
      con = contacts.get(0);
    }
    return con;
  }

  @Override
  public void newContact(final Contact contact) {
    final String userDn =
      this.ldapContextSource.getAuthenticationSource().getPrincipal();
    contact.setDistinguishedName(
      new DistinguishedName("uid="+contact.getUid()+ "," +userDn));
    getOdmManager().create(contact);
  }

  @Override
  public void updateContact(final Contact contact) {
    final String userDn =
      this.ldapContextSource.getAuthenticationSource().getPrincipal();
    contact.setDistinguishedName(
      new DistinguishedName("uid="+contact.getUid()+ "," +userDn));
    getOdmManager().update(contact);
  }

  @Override
  public void delete(final String contactId) {
    final Contact con = this.get(contactId);
    if (con != null) {
      getOdmManager().delete(con);
    } else {
      // escaping apostrophes
      //http://stackoverflow.com/questions/3399165/java-util-logging-message-template-question
      LOG.log(
        Level.INFO, "Can''t delete, no such contact?: {0}",
          new Object[] { contactId });
    }
  }

  @Override
  public Boolean exists(final String contactId) {
    Boolean result = false;
    final Contact con = this.get(contactId);
    if (con != null) {
      result = true;
    }
    return result;
  }

  /**
   * @return the ldapContextSource
   */
  public LdapContextSource getLdapContextSource() {
    return ldapContextSource;
  }

  /**
   * @param ldapContextSource the ldapContextSource to set
   */
  public void setLdapContextSource(final LdapContextSource ldapContextSource) {
    this.ldapContextSource = ldapContextSource;
  }

  /**
   * @return the odmManager
   */
  public OdmManager getOdmManager() {
    return odmManager;
  }

  /**
   * @param odmManager the odmManager to set
   */
  public void setOdmManager(final OdmManager odmManager) {
    this.odmManager = odmManager;
  }
}
