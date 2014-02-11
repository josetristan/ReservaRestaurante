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
 * on 2014-02-07 at 09:15:39 UTC 
 * Modify at your own risk.
 */

package com.jtristan.reservarestaurante.entidad.ofertaendpoint.model;

/**
 * Model definition for Oferta.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the ofertaendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Oferta extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String clave;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String descripcion;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.String> diasDisponibles;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Restaurante restaurante;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClave() {
    return clave;
  }

  /**
   * @param clave clave or {@code null} for none
   */
  public Oferta setClave(java.lang.String clave) {
    this.clave = clave;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion descripcion or {@code null} for none
   */
  public Oferta setDescripcion(java.lang.String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.String> getDiasDisponibles() {
    return diasDisponibles;
  }

  /**
   * @param diasDisponibles diasDisponibles or {@code null} for none
   */
  public Oferta setDiasDisponibles(java.util.List<java.lang.String> diasDisponibles) {
    this.diasDisponibles = diasDisponibles;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Restaurante getRestaurante() {
    return restaurante;
  }

  /**
   * @param restaurante restaurante or {@code null} for none
   */
  public Oferta setRestaurante(Restaurante restaurante) {
    this.restaurante = restaurante;
    return this;
  }

  @Override
  public Oferta set(String fieldName, Object value) {
    return (Oferta) super.set(fieldName, value);
  }

  @Override
  public Oferta clone() {
    return (Oferta) super.clone();
  }

}