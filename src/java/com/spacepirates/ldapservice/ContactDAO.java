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
import java.util.List;

/**
 *
 * @author Scott Douglass
 */
public interface ContactDAO {

  List<Contact> getContacts();

  Contact get(String contact);

  void newContact(Contact contact);

  void updateContact(Contact contact);

  void delete(String contact);

  Boolean exists(String contactId);
}
