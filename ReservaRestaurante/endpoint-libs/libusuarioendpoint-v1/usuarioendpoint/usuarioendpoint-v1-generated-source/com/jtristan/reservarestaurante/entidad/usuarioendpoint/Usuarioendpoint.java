/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-12-19 23:55:21 UTC)
 * on 2014-02-07 at 09:15:58 UTC 
 * Modify at your own risk.
 */

package com.jtristan.reservarestaurante.entidad.usuarioendpoint;

/**
 * Service definition for Usuarioendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link UsuarioendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Usuarioendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the usuarioendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://stoked-sun-469.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "usuarioendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Usuarioendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Usuarioendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getUsuario".
   *
   * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
   * optional parameters, call the {@link GetUsuario#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetUsuario getUsuario(java.lang.Long id) throws java.io.IOException {
    GetUsuario result = new GetUsuario(id);
    initialize(result);
    return result;
  }

  public class GetUsuario extends UsuarioendpointRequest<com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario> {

    private static final String REST_PATH = "usuario/{id}";

    /**
     * Create a request for the method "getUsuario".
     *
     * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
     * optional parameters, call the {@link GetUsuario#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetUsuario#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetUsuario(java.lang.Long id) {
      super(Usuarioendpoint.this, "GET", REST_PATH, null, com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUsuario setAlt(java.lang.String alt) {
      return (GetUsuario) super.setAlt(alt);
    }

    @Override
    public GetUsuario setFields(java.lang.String fields) {
      return (GetUsuario) super.setFields(fields);
    }

    @Override
    public GetUsuario setKey(java.lang.String key) {
      return (GetUsuario) super.setKey(key);
    }

    @Override
    public GetUsuario setOauthToken(java.lang.String oauthToken) {
      return (GetUsuario) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUsuario setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUsuario) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUsuario setQuotaUser(java.lang.String quotaUser) {
      return (GetUsuario) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUsuario setUserIp(java.lang.String userIp) {
      return (GetUsuario) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetUsuario setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetUsuario set(String parameterName, Object value) {
      return (GetUsuario) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertUsuario".
   *
   * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
   * optional parameters, call the {@link InsertUsuario#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario}
   * @return the request
   */
  public InsertUsuario insertUsuario(com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario content) throws java.io.IOException {
    InsertUsuario result = new InsertUsuario(content);
    initialize(result);
    return result;
  }

  public class InsertUsuario extends UsuarioendpointRequest<com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario> {

    private static final String REST_PATH = "usuario";

    /**
     * Create a request for the method "insertUsuario".
     *
     * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
     * optional parameters, call the {@link InsertUsuario#execute()} method to invoke the remote
     * operation. <p> {@link InsertUsuario#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario}
     * @since 1.13
     */
    protected InsertUsuario(com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario content) {
      super(Usuarioendpoint.this, "POST", REST_PATH, content, com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario.class);
    }

    @Override
    public InsertUsuario setAlt(java.lang.String alt) {
      return (InsertUsuario) super.setAlt(alt);
    }

    @Override
    public InsertUsuario setFields(java.lang.String fields) {
      return (InsertUsuario) super.setFields(fields);
    }

    @Override
    public InsertUsuario setKey(java.lang.String key) {
      return (InsertUsuario) super.setKey(key);
    }

    @Override
    public InsertUsuario setOauthToken(java.lang.String oauthToken) {
      return (InsertUsuario) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertUsuario setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertUsuario) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertUsuario setQuotaUser(java.lang.String quotaUser) {
      return (InsertUsuario) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertUsuario setUserIp(java.lang.String userIp) {
      return (InsertUsuario) super.setUserIp(userIp);
    }

    @Override
    public InsertUsuario set(String parameterName, Object value) {
      return (InsertUsuario) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listUsuario".
   *
   * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
   * optional parameters, call the {@link ListUsuario#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListUsuario listUsuario() throws java.io.IOException {
    ListUsuario result = new ListUsuario();
    initialize(result);
    return result;
  }

  public class ListUsuario extends UsuarioendpointRequest<com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.CollectionResponseUsuario> {

    private static final String REST_PATH = "usuario";

    /**
     * Create a request for the method "listUsuario".
     *
     * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
     * optional parameters, call the {@link ListUsuario#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListUsuario#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListUsuario() {
      super(Usuarioendpoint.this, "GET", REST_PATH, null, com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.CollectionResponseUsuario.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListUsuario setAlt(java.lang.String alt) {
      return (ListUsuario) super.setAlt(alt);
    }

    @Override
    public ListUsuario setFields(java.lang.String fields) {
      return (ListUsuario) super.setFields(fields);
    }

    @Override
    public ListUsuario setKey(java.lang.String key) {
      return (ListUsuario) super.setKey(key);
    }

    @Override
    public ListUsuario setOauthToken(java.lang.String oauthToken) {
      return (ListUsuario) super.setOauthToken(oauthToken);
    }

    @Override
    public ListUsuario setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListUsuario) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListUsuario setQuotaUser(java.lang.String quotaUser) {
      return (ListUsuario) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListUsuario setUserIp(java.lang.String userIp) {
      return (ListUsuario) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListUsuario setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String mail;

    /**

     */
    public java.lang.String getMail() {
      return mail;
    }

    public ListUsuario setMail(java.lang.String mail) {
      this.mail = mail;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListUsuario setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListUsuario set(String parameterName, Object value) {
      return (ListUsuario) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeUsuario".
   *
   * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
   * optional parameters, call the {@link RemoveUsuario#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveUsuario removeUsuario(java.lang.Long id) throws java.io.IOException {
    RemoveUsuario result = new RemoveUsuario(id);
    initialize(result);
    return result;
  }

  public class RemoveUsuario extends UsuarioendpointRequest<Void> {

    private static final String REST_PATH = "usuario/{id}";

    /**
     * Create a request for the method "removeUsuario".
     *
     * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
     * optional parameters, call the {@link RemoveUsuario#execute()} method to invoke the remote
     * operation. <p> {@link RemoveUsuario#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveUsuario(java.lang.Long id) {
      super(Usuarioendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveUsuario setAlt(java.lang.String alt) {
      return (RemoveUsuario) super.setAlt(alt);
    }

    @Override
    public RemoveUsuario setFields(java.lang.String fields) {
      return (RemoveUsuario) super.setFields(fields);
    }

    @Override
    public RemoveUsuario setKey(java.lang.String key) {
      return (RemoveUsuario) super.setKey(key);
    }

    @Override
    public RemoveUsuario setOauthToken(java.lang.String oauthToken) {
      return (RemoveUsuario) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveUsuario setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveUsuario) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveUsuario setQuotaUser(java.lang.String quotaUser) {
      return (RemoveUsuario) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveUsuario setUserIp(java.lang.String userIp) {
      return (RemoveUsuario) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveUsuario setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveUsuario set(String parameterName, Object value) {
      return (RemoveUsuario) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateUsuario".
   *
   * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
   * optional parameters, call the {@link UpdateUsuario#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario}
   * @return the request
   */
  public UpdateUsuario updateUsuario(com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario content) throws java.io.IOException {
    UpdateUsuario result = new UpdateUsuario(content);
    initialize(result);
    return result;
  }

  public class UpdateUsuario extends UsuarioendpointRequest<com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario> {

    private static final String REST_PATH = "usuario";

    /**
     * Create a request for the method "updateUsuario".
     *
     * This request holds the parameters needed by the the usuarioendpoint server.  After setting any
     * optional parameters, call the {@link UpdateUsuario#execute()} method to invoke the remote
     * operation. <p> {@link UpdateUsuario#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario}
     * @since 1.13
     */
    protected UpdateUsuario(com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario content) {
      super(Usuarioendpoint.this, "PUT", REST_PATH, content, com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario.class);
    }

    @Override
    public UpdateUsuario setAlt(java.lang.String alt) {
      return (UpdateUsuario) super.setAlt(alt);
    }

    @Override
    public UpdateUsuario setFields(java.lang.String fields) {
      return (UpdateUsuario) super.setFields(fields);
    }

    @Override
    public UpdateUsuario setKey(java.lang.String key) {
      return (UpdateUsuario) super.setKey(key);
    }

    @Override
    public UpdateUsuario setOauthToken(java.lang.String oauthToken) {
      return (UpdateUsuario) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateUsuario setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateUsuario) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateUsuario setQuotaUser(java.lang.String quotaUser) {
      return (UpdateUsuario) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateUsuario setUserIp(java.lang.String userIp) {
      return (UpdateUsuario) super.setUserIp(userIp);
    }

    @Override
    public UpdateUsuario set(String parameterName, Object value) {
      return (UpdateUsuario) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Usuarioendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Usuarioendpoint}. */
    @Override
    public Usuarioendpoint build() {
      return new Usuarioendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link UsuarioendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUsuarioendpointRequestInitializer(
        UsuarioendpointRequestInitializer usuarioendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(usuarioendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
