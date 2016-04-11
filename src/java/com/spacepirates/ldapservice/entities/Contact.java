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
package com.spacepirates.ldapservice.entities;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

/**
 *
 * @author Scott Douglass
 */
@XmlRootElement
@Entry(objectClasses = {"inetOrgPerson", "inetLocalMailRecipient",
  "mgOrgPerson", "evolutionPerson"})
public final class Contact {

  @Id
  private DistinguishedName distinguishedName;
  @Attribute(name = "uid")
  private String uid;
  @Attribute(name = "givenName")
  private String firstName;
  @Attribute(name = "sn")
  private String lastName;
  @Attribute(name = "nickname")
  private String nickname;
  @Attribute(name = "cn")
  private String displayName;
  @Attribute(name = "mail")
  private String primaryEmail;
  @Attribute(name = "secondEmail")
  private String secondaryEmail;
  @Attribute(name = "homePhone")
  private String homePhone;
  @Attribute(name = "telephoneNumber")
  private String workPhone;
  @Attribute(name = "pager")
  private String pagerNumber;
  @Attribute(name = "facsimileTelephoneNumber")
  private String faxNumber;
  @Attribute(name = "mobile")
  private String mobileNumber;
  @Attribute(name = "useHtmlMail")
  private Boolean htmlEmail;
  @Attribute(name = "homePostalAddress")
  private String homePostalAddress;
  @Attribute(name = "homePostalAdress2")
  private String homePostalAdress2;
  @Attribute(name = "homeLocalityName")
  private String homeLocalityName;
  @Attribute(name = "homeState")
  private String homeState;
  @Attribute(name = "homePostalCode")
  private String homePostalCode;
  @Attribute(name = "homeCountryCode")
  private String homeCountryCode;
  @Attribute(name = "postalAddress")
  private String postalAddress;
  @Attribute(name = "postalAdress2")
  private String postalAdress2;
  @Attribute(name = "l")
  private String localityName;
  @Attribute(name = "st")
  private String state;
  @Attribute(name = "postalCode")
  private String postalCode;
  @Attribute(name = "c")
  private String countryCode;
  @Attribute(name = "title")
  private String title;
  @Attribute(name = "ou")
  private String group;
  @Attribute(name = "o")
  private String organization;
  @Attribute(name = "workurl")
  private String workUrl;
  @Attribute(name = "homeurl")
  private String homeUrl;
  @Attribute(name = "custom1")
  private String custom1;
  @Attribute(name = "custom2")
  private String custom2;
  @Attribute(name = "custom3")
  private String custom3;
  @Attribute(name = "custom4")
  private String custom4;
  @Attribute(name = "description")
  private String description;

  public Contact() {
    //Empty constructor for POJO purposes
  }

  public Contact(final String uid, final String firstName, final String lastName,
    final String nickname, final String displayName, final String primaryEmail,
    final String secondaryEmail, final String homePhone, final String workPhone,
    final String pagerNumber, final String faxNumber, final String mobileNumber,
    final Boolean htmlEmail) {
    this.uid = uid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.displayName = displayName;
    this.primaryEmail = primaryEmail;
    this.secondaryEmail = secondaryEmail;
    this.homePhone = homePhone;
    this.workPhone = workPhone;
    this.pagerNumber = pagerNumber;
    this.faxNumber = faxNumber;
    this.mobileNumber = mobileNumber;
    this.htmlEmail = htmlEmail;
  }

  public Contact(final DistinguishedName distinguishedName, final String uid,
    final String firstName, final String lastName, final String nickname,
    final String displayName, final String primaryEmail,
    final String secondaryEmail, final String homePhone, final String workPhone,
    final String pagerNumber, final String faxNumber, final String mobileNumber,
    final Boolean htmlEmail, final String homePostalAddress,
    final String homePostalAdress2, final String homeLocalityName,
    final String homeState, final String homePostalCode,
    final String homeCountryCode, final String postalAddress,
    final String postalAdress2, final String localityName,
    final String state, final String postalCode, final String countryCode,
    final String title, final String group, final String organization,
    final String workUrl, final String homeUrl, final String custom1,
    final String custom2, final String custom3, final String custom4,
    final String description) {
    this.distinguishedName = distinguishedName;
    this.uid = uid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.displayName = displayName;
    this.primaryEmail = primaryEmail;
    this.secondaryEmail = secondaryEmail;
    this.homePhone = homePhone;
    this.workPhone = workPhone;
    this.pagerNumber = pagerNumber;
    this.faxNumber = faxNumber;
    this.mobileNumber = mobileNumber;
    this.htmlEmail = htmlEmail;
    this.homePostalAddress = homePostalAddress;
    this.homePostalAdress2 = homePostalAdress2;
    this.homeLocalityName = homeLocalityName;
    this.homeState = homeState;
    this.homePostalCode = homePostalCode;
    this.homeCountryCode = homeCountryCode;
    this.postalAddress = postalAddress;
    this.postalAdress2 = postalAdress2;
    this.localityName = localityName;
    this.state = state;
    this.postalCode = postalCode;
    this.countryCode = countryCode;
    this.title = title;
    this.group = group;
    this.organization = organization;
    this.workUrl = workUrl;
    this.homeUrl = homeUrl;
    this.custom1 = custom1;
    this.custom2 = custom2;
    this.custom3 = custom3;
    this.custom4 = custom4;
    this.description = description;
  }

  /**
   * @return the uid
   */
  public String getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(final String uid) {
    this.uid = uid;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the nickname
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * @param nickname the nickname to set
   */
  public void setNickname(final String nickname) {
    this.nickname = nickname;
  }

  /**
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param displayName the displayName to set
   */
  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }

  /**
   * @return the primaryEmail
   */
  public String getPrimaryEmail() {
    return primaryEmail;
  }

  /**
   * @param primaryEmail the primaryEmail to set
   */
  public void setPrimaryEmail(final String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }

  /**
   * @return the secondaryEmail
   */
  public String getSecondaryEmail() {
    return secondaryEmail;
  }

  /**
   * @param secondaryEmail the secondaryEmail to set
   */
  public void setSecondaryEmail(final String secondaryEmail) {
    this.secondaryEmail = secondaryEmail;
  }

  /**
   * @return the homePhone
   */
  public String getHomePhone() {
    return homePhone;
  }

  /**
   * @param homePhone the homePhone to set
   */
  public void setHomePhone(final String homePhone) {
    this.homePhone = homePhone;
  }

  /**
   * @return the workPhone
   */
  public String getWorkPhone() {
    return workPhone;
  }

  /**
   * @param workPhone the workPhone to set
   */
  public void setWorkPhone(final String workPhone) {
    this.workPhone = workPhone;
  }

  /**
   * @return the pagerNumber
   */
  public String getPagerNumber() {
    return pagerNumber;
  }

  /**
   * @param pagerNumber the pagerNumber to set
   */
  public void setPagerNumber(final String pagerNumber) {
    this.pagerNumber = pagerNumber;
  }

  /**
   * @return the faxNumber
   */
  public String getFaxNumber() {
    return faxNumber;
  }

  /**
   * @param faxNumber the faxNumber to set
   */
  public void setFaxNumber(final String faxNumber) {
    this.faxNumber = faxNumber;
  }

  /**
   * @return the mobileNumber
   */
  public String getMobileNumber() {
    return mobileNumber;
  }

  /**
   * @param mobileNumber the mobileNumber to set
   */
  public void setMobileNumber(final String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * @return the htmlEmail
   */
  public Boolean isHtmlEmail() {
    return htmlEmail;
  }

  /**
   * @param htmlEmail the htmlEmail to set
   */
  public void setHtmlEmail(final Boolean htmlEmail) {
    this.htmlEmail = htmlEmail;
  }

  /**
   * @return the distinguishedName
   */
  public DistinguishedName getDistinguishedName() {
    return distinguishedName;
  }

  /**
   * @param distinguishedName the distinguishedName to set
   */
  public void setDistinguishedName(final DistinguishedName distinguishedName) {
    this.distinguishedName = distinguishedName;
  }

  /**
   * @return the homePostalAddress
   */
  public String getHomePostalAddress() {
    return homePostalAddress;
  }

  /**
   * @param homePostalAddress the homePostalAddress to set
   */
  public void setHomePostalAddress(final String homePostalAddress) {
    this.homePostalAddress = homePostalAddress;
  }

  /**
   * @return the homePostalAdress2
   */
  public String getHomePostalAdress2() {
    return homePostalAdress2;
  }

  /**
   * @param homePostalAdress2 the homePostalAdress2 to set
   */
  public void setHomePostalAdress2(final String homePostalAdress2) {
    this.homePostalAdress2 = homePostalAdress2;
  }

  /**
   * @return the homeLocalityName
   */
  public String getHomeLocalityName() {
    return homeLocalityName;
  }

  /**
   * @param homeLocalityName the homeLocalityName to set
   */
  public void setHomeLocalityName(final String homeLocalityName) {
    this.homeLocalityName = homeLocalityName;
  }

  /**
   * @return the homeState
   */
  public String getHomeState() {
    return homeState;
  }

  /**
   * @param homeState the homeState to set
   */
  public void setHomeState(final String homeState) {
    this.homeState = homeState;
  }

  /**
   * @return the homePostalCode
   */
  public String getHomePostalCode() {
    return homePostalCode;
  }

  /**
   * @param homePostalCode the homePostalCode to set
   */
  public void setHomePostalCode(final String homePostalCode) {
    this.homePostalCode = homePostalCode;
  }

  /**
   * @return the homeCountryCode
   */
  public String getHomeCountryCode() {
    return homeCountryCode;
  }

  /**
   * @param homeCountryCode the homeCountryCode to set
   */
  public void setHomeCountryCode(final String homeCountryCode) {
    this.homeCountryCode = homeCountryCode;
  }

  /**
   * @return the postalAddress
   */
  public String getPostalAddress() {
    return postalAddress;
  }

  /**
   * @param postalAddress the postalAddress to set
   */
  public void setPostalAddress(final String postalAddress) {
    this.postalAddress = postalAddress;
  }

  /**
   * @return the postalAdress2
   */
  public String getPostalAdress2() {
    return postalAdress2;
  }

  /**
   * @param postalAdress2 the postalAdress2 to set
   */
  public void setPostalAdress2(final String postalAdress2) {
    this.postalAdress2 = postalAdress2;
  }

  /**
   * @return the localityName
   */
  public String getLocalityName() {
    return localityName;
  }

  /**
   * @param localityName the localityName to set
   */
  public void setLocalityName(final String localityName) {
    this.localityName = localityName;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(final String state) {
    this.state = state;
  }

  /**
   * @return the postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @param postalCode the postalCode to set
   */
  public void setPostalCode(final String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * @param countryCode the countryCode to set
   */
  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * @return the group
   */
  public String getGroup() {
    return group;
  }

  /**
   * @param group the group to set
   */
  public void setGroup(final String group) {
    this.group = group;
  }

  /**
   * @return the organization
   */
  public String getOrganization() {
    return organization;
  }

  /**
   * @param organization the organization to set
   */
  public void setOrganization(final String organization) {
    this.organization = organization;
  }

  /**
   * @return the workUrl
   */
  public String getWorkUrl() {
    return workUrl;
  }

  /**
   * @param workUrl the workUrl to set
   */
  public void setWorkUrl(final String workUrl) {
    this.workUrl = workUrl;
  }

  /**
   * @return the homeUrl
   */
  public String getHomeUrl() {
    return homeUrl;
  }

  /**
   * @param homeUrl the homeUrl to set
   */
  public void setHomeUrl(final String homeUrl) {
    this.homeUrl = homeUrl;
  }

  /**
   * @return the custom1
   */
  public String getCustom1() {
    return custom1;
  }

  /**
   * @param custom1 the custom1 to set
   */
  public void setCustom1(final String custom1) {
    this.custom1 = custom1;
  }

  /**
   * @return the custom2
   */
  public String getCustom2() {
    return custom2;
  }

  /**
   * @param custom2 the custom2 to set
   */
  public void setCustom2(final String custom2) {
    this.custom2 = custom2;
  }

  /**
   * @return the custom3
   */
  public String getCustom3() {
    return custom3;
  }

  /**
   * @param custom3 the custom3 to set
   */
  public void setCustom3(final String custom3) {
    this.custom3 = custom3;
  }

  /**
   * @return the custom4
   */
  public String getCustom4() {
    return custom4;
  }

  /**
   * @param custom4 the custom4 to set
   */
  public void setCustom4(final String custom4) {
    this.custom4 = custom4;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}
