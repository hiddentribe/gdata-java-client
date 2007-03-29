/* Copyright (c) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.google.gdata.client.spreadsheet;


import com.google.gdata.client.GoogleService;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetFeed;

import java.net.URL;


/**
 * The SpreadsheetService class extends the basic {@link GoogleService}
 * abstraction to define a service that is preconfigured for access
 * to the Google Spreadsheet data API.
 *
 * 
 * 
 * 
 * @see com.google.gdata.client.spreadsheet.FeedURLFactory#getDefault()
 */
public class SpreadsheetService extends GoogleService {

  /**
   * The abbreviated name of Spreadsheet recognized by Google.  The service
   * name is used while requesting an authentication token.
   */
  public static final String SPREADSHEET_SERVICE = "wise";

  /**
   * The version ID of the service.
   */
  public static final String SPREADSHEET_SERVICE_VERSION = 
      "GSpread-Java/" +
      SpreadsheetService.class.getPackage().getImplementationVersion();

  /**
   * Constructs a SpreadsheetService instance connecting to the
   * Spreadsheet service for an application with the name
   * {@code applicationName}.
   * 
   * @param applicationName the name of the client application accessing the 
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version]. 
   *                        The name will be used by the Google servers to 
   *                        monitor the source of authentication.
   */
  public SpreadsheetService(String applicationName) {
    super(SPREADSHEET_SERVICE, applicationName);
    addExtensions();
  }


  /**
   * Constructs a GoogleService instance connecting to the service with name
   * {@code serviceName} for an application with the name
   * {@code applicationName}.  The service will authenticate at the provided
   * {@code domainName}.   
   * 
   * @param applicationName the name of the client application accessing the 
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version]. 
   *                        The name will be used by the Google servers to 
   *                        monitor the source of authentication.
   * @param protocol        name of protocol to use for authentication 
   *                        ("http"/"https")
   * @param domainName      the name of the domain hosting the login handler
   */
  public SpreadsheetService(String applicationName,
                            String protocol,
                            String domainName) {
    super(SPREADSHEET_SERVICE, applicationName, protocol, domainName);
    addExtensions();
  }

  /**
   * Adds the Google Spreadsheets extensions.
   */
  private void addExtensions() {
    ExtensionProfile extensionProfile = getExtensionProfile();
    new CellFeed().declareExtensions(extensionProfile);
    new ListFeed().declareExtensions(extensionProfile);
    new WorksheetFeed().declareExtensions(extensionProfile);
  }


  public String getServiceVersion() {
    return SPREADSHEET_SERVICE_VERSION + " " + super.getServiceVersion();
  }

}
