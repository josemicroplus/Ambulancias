/**
 * wsGestplusAPI
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.microplus.wsGestplus.models

/**
 * 
 * @param xmlEnvio 
 * @param xmlRecepcao 
 * @param atReturnCode 
 * @param atReturnMessage 
 * @param atReturnDocumentNumber 
 * @param atDocCodeID 
 * @param atDocAnulado 
 * @param erro 
 */
data class TransportDocument (

    val xmlEnvio: kotlin.String? = null,
    val xmlRecepcao: kotlin.String? = null,
    val atReturnCode: Int? = null,
    val atReturnMessage: kotlin.String? = null,
    val atReturnDocumentNumber: kotlin.String? = null,
    val atDocCodeID: kotlin.String? = null,
    val atDocAnulado: kotlin.Boolean? = null,
    val erro: GestError? = null
) {
}