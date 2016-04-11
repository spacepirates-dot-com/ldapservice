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
import com.sun.jersey.api.NotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Scott Douglass
 */
@Component
public class ContactResource {

  @Context private UriInfo uriInfo;
  @Context private Request request;
  @Autowired private ContactDAO contactDao;

  private String contactId;

  public ContactResource() {
    //Empty contructed needed
  }

  public ContactResource(final UriInfo uriInfo, final Request request,
    final String contactId) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.contactId = contactId;
  }
  public ContactResource(final UriInfo uriInfo, final Request request,
    final String contactId, final ContactDAO contactDao) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.contactId = contactId;
    this.contactDao = contactDao;
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Contact getContact() {
    final Contact cont = getContactDao().get(getContactId());
    if (cont == null) {
      throw new NotFoundException("No such Contact.");
    }
    return cont;
  }

  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public void newContact(final JAXBElement<Contact> jaxbContact) {
    final Contact con = jaxbContact.getValue();
    getContactDao().newContact(con);
  }

  @POST
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void newContact(
    @FormParam("uid") final String uid,
    @FormParam("firstName") final String firstName,
    @FormParam("lastName") final String lastName,
    @FormParam("nickname") final String nickname,
    @FormParam("displayName") final String displayName,
    @FormParam("primaryEmail") final String primaryEmail,
    @FormParam("secondaryEmail") final String secondaryEmail,
    @FormParam("homePhone") final String homePhone,
    @FormParam("workPhone") final String workPhone,
    @FormParam("pagerNumber") final String pagerNumber,
    @FormParam("faxNumber") final String faxNumber,
    @FormParam("mobileNumber") final String mobileNumber,
    @FormParam("htmlEmail") final Boolean htmlEmail,
    @Context final HttpServletResponse servletResponse,
    @Context final HttpServletRequest servletRequest)
    throws IOException {

    final Contact con = new Contact();
    if (StringUtils.isEmpty(uid)) {
      con.setUid("id" +  new Date().getTime());
    } else {
      con.setUid(uid);
    }
    con.setFirstName(firstName);
    con.setLastName(lastName);
    con.setNickname(nickname);
    con.setDisplayName(displayName);
    con.setPrimaryEmail(primaryEmail);
    con.setSecondaryEmail(secondaryEmail);
    con.setHomePhone(homePhone);
    con.setWorkPhone(workPhone);
    con.setPagerNumber(pagerNumber);
    con.setMobileNumber(mobileNumber);
    con.setFaxNumber(faxNumber);
    con.setHtmlEmail(htmlEmail);

    getContactDao().newContact(con);


    final URI uri = uriInfo.getAbsolutePathBuilder().path(uid).build();
    Response.created(uri).build();

    servletResponse.sendRedirect(servletRequest.getContextPath() + "/" + uid);
  }

  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putContact(final JAXBElement<Contact> jaxbContact) {
    final Contact con = jaxbContact.getValue();
    return putAndGetResponse(con);
  }

  private Response putAndGetResponse(final Contact inContact) {
    Response res;
    if (getContactDao().exists(inContact.getUid())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    getContactDao().updateContact(inContact);
    return res;
  }

  @DELETE
  public void deleteContact() {
    getContactDao().delete(getContactId());
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

  public Request getRequest() {
    return this.request;
  }
  public void setRequest(final Request inRequest) {
    this.request = inRequest;
  }

  public UriInfo getUriInfo() {
    return this.uriInfo;
  }
  public void setUriInfo(final UriInfo inUriInfo) {
    this.uriInfo = inUriInfo;
  }

  /**
   * @return the contactId
   */
  public String getContactId() {
    return contactId;
  }

  /**
   * @param contactId the contactId to set
   */
  public void setContactId(String contactId) {
    this.contactId = contactId;
  }
}
