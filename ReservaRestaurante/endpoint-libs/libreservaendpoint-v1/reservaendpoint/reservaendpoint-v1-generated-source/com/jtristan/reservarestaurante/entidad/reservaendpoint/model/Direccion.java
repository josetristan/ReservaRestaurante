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
 * on 2014-02-07 at 09:14:57 UTC 
 * Modify at your own risk.
 */

package com.jtristan.reservarestaurante.entidad.reservaendpoint.model;

/**
 * Model definition for Direccion.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the reservaendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Direccion extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String direccion;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer numero;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String tipo;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion direccion or {@code null} for none
   */
  public Direccion setDireccion(java.lang.String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNumero() {
    return numero;
  }

  /**
   * @param numero numero or {@code null} for none
   */
  public Direccion setNumero(java.lang.Integer numero) {
    this.numero = numero;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTipo() {
    return tipo;
  }

  /**
   * @param tipo tipo or {@code null} for none
   */
  public Direccion setTipo(java.lang.String tipo) {
    this.tipo = tipo;
    return this;
  }

  @Override
  public Direccion set(String fieldName, Object value) {
    return (Direccion) super.set(fieldName, value);
  }

  @Override
  public Direccion clone() {
    return (Direccion) super.clone();
  }

}
