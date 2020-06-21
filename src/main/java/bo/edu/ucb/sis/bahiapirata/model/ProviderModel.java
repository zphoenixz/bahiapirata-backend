package bo.edu.ucb.sis.bahiapirata.model;

import java.sql.Timestamp;

public class ProviderModel {
    private Integer providerId;
    private Integer providerName;
    private String catCountry;

    public ProviderModel() {
    }

    public ProviderModel(Integer providerId, Integer providerName, String catCountry) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.catCountry = catCountry;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderName() {
        return providerName;
    }

    public void setProviderName(Integer providerName) {
        this.providerName = providerName;
    }

    public String getCatCountry() {
        return catCountry;
    }

    public void setCatCountry(String catCountry) {
        this.catCountry = catCountry;
    }

    @Override
    public String toString() {
        return "ProviderModel{" +
                "providerId=" + providerId +
                ", providerName=" + providerName +
                ", catCountry='" + catCountry + '\'' +
                '}';
    }
}
