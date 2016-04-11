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

/**
 *
 * @author Scott Douglass
 */
public class ContactMockDAO implements ContactDAO {

  @Override
  public List<Contact> getContacts() {
    final List<Contact> contacts = new ArrayList<Contact>();
    contacts.add(new Contact("1", "Joe", "Lion", "JoeL",
      "Joe Lion", "joelion@jungle.com", "",
      "510 222 5555", "", "", "",
      "510 333 6666", false));
    contacts.add(new Contact("2", "Sam", "Snake", "SamS",
      "Sam Snake", "samsnake@jungle.com", "",
      "510 444 5555", "", "", "",
      "510 555 6666", false));
    return contacts;
  }

  @Override
  public Contact get(final String contact) {
    return new Contact();
  }

  @Override
  public void newContact(final Contact contact) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void updateContact(final Contact contact) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void delete(final String contactId) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Boolean exists(final String contactId) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
