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

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weight_threshold",
    "account_auths",
    "key_auths"
})
public class Owner {

    @JsonProperty("weight_threshold")
    private Integer weightThreshold;
    @JsonProperty("account_auths")
    private List<Object> accountAuths = null;
    @JsonProperty("key_auths")
    private List<List<String>> keyAuths = null;

    @JsonProperty("weight_threshold")
    public Integer getWeightThreshold() {
        return weightThreshold;
    }

    @JsonProperty("weight_threshold")
    public void setWeightThreshold(Integer weightThreshold) {
        this.weightThreshold = weightThreshold;
    }

    @JsonProperty("account_auths")
    public List<Object> getAccountAuths() {
        return accountAuths;
    }

    @JsonProperty("account_auths")
    public void setAccountAuths(List<Object> accountAuths) {
        this.accountAuths = accountAuths;
    }

    @JsonProperty("key_auths")
    public List<List<String>> getKeyAuths() {
        return keyAuths;
    }

    @JsonProperty("key_auths")
    public void setKeyAuths(List<List<String>> keyAuths) {
        this.keyAuths = keyAuths;
    }

}
