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
    "current_mana",
    "last_update_time"
})
public class VotingManabar {

    @JsonProperty("current_mana")
    private String currentMana;
    @JsonProperty("last_update_time")
    private Integer lastUpdateTime;

    @JsonProperty("current_mana")
    public String getCurrentMana() {
        return currentMana;
    }

    @JsonProperty("current_mana")
    public void setCurrentMana(String currentMana) {
        this.currentMana = currentMana;
    }

    @JsonProperty("last_update_time")
    public Integer getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("last_update_time")
    public void setLastUpdateTime(Integer lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
