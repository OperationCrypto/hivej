/*
 *     This file is part of HiveJ
 * 
 *     HiveJ is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     HiveJ is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with HiveJ.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.operationcrypto.hivej.api.database.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "precision",
    "nai"
})
public class RewardSbdBalance {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("precision")
    private Integer precision;
    @JsonProperty("nai")
    private String nai;

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("precision")
    public Integer getPrecision() {
        return precision;
    }

    @JsonProperty("precision")
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    @JsonProperty("nai")
    public String getNai() {
        return nai;
    }

    @JsonProperty("nai")
    public void setNai(String nai) {
        this.nai = nai;
    }

}
