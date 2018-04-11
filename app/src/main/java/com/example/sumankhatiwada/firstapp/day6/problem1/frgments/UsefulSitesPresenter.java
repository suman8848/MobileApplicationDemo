package com.example.sumankhatiwada.firstapp.day6.problem1.frgments;

import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginRegisterPresenter;
import com.example.sumankhatiwada.firstapp.day6.problem1.domain.WebDomain;

import java.util.List;

/**
 * Created by sumankhatiwada on 4/10/18.
 */

public class UsefulSitesPresenter  {

    WebDomain webDomain = new WebDomain();

    public List<WebDomain> getWebList(){
        return webDomain.getWebDomainList();
    }

    public void setDefaultWebSite(){
        webDomain.setDefaultWebSites();
    }

    public void addToFavouriteList(WebDomain webDomain) {
        webDomain.setFavouriteUrl(true);
    }

    private static UsefulSitesPresenter singletonSites = new UsefulSitesPresenter( );

    private UsefulSitesPresenter() {

    }

    public static UsefulSitesPresenter getInstance( ) {
        return singletonSites;
    }

    public void clear() {
        webDomain.clearList();
    }
}
