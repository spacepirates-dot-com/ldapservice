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

package com.spacepirates.ldapservice.resources;

import com.spacepirates.ldapservice.ContactDAO;
import com.spacepirates.ldapservice.entities.Contact;
import com.sun.jersey.api.core.ResourceContext;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Scott Douglass
 */
@Component
@Path("/")
public class AddressBookResource {

  @Context private ResourceContext resourceContext;
  @Context private UriInfo uriInfo;
  @Context private Request request;
  @Autowired private ContactDAO contactDao;

  /**
   * Empty constructor needed by Jersey framework.
   */
  public AddressBookResource() {
    //Empty constructor needed by Jersey framework.
  }

  public AddressBookResource(final UriInfo inUriInfo, final Request inRequest) {
    this.uriInfo = inUriInfo;
    this.request = inRequest;
  }

  /*
   * Note that the "accepts" header sent by a client can determine if
   * the XML or the JSON result is returned. See:
   * http://stackoverflow.com/questions/2744972/beyond-the-produces-annotation-how-does-jersey-jax-rs-know-to-treat-a-pojo-a
   */
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Contact> getContacts() {
    final List<Contact> contacts = new ArrayList<Contact>();
    contacts.addAll(getContactDao().getContacts());
    return contacts;
  }

  @Path("{contactId}")
  public ContactResource getContact(
    @PathParam("contactId") final String contactId) {
    ContactResource conres = getResourceContext().getResource(ContactResource.class);
    conres.setContactId(contactId);
    return conres;
  }

  /**
   * @return the contactDao
   */
  public ContactDAO getContactDao() {
    return contactDao;
  }

  /**
   * @param contactDao the contactDao to set
   */
  public void setContactDao(final ContactDAO contactDao) {
    this.contactDao = contactDao;
  }

  /**
   * @return the uriInfo
   */
  public UriInfo getUriInfo() {
    return uriInfo;
  }

  /**
   * @param uriInfo the uriInfo to set
   */
  public void setUriInfo(final UriInfo uriInfo) {
    this.uriInfo = uriInfo;
  }

  /**
   * @return the request
   */
  public Request getRequest() {
    return request;
  }

  /**
   * @param request the request to set
   */
  public void setRequest(final Request request) {
    this.request = request;
  }

  /**
   * @return the resourceContext
   */
  public ResourceContext getResourceContext() {
    return resourceContext;
  }

  /**
   * @param resourceContext the resourceContext to set
   */
  public void setResourceContext(ResourceContext resourceContext) {
    this.resourceContext = resourceContext;
  }
}
