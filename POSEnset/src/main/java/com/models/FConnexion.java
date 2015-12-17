/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.beans.Constants;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

/**
 *
 * @author elmottaki
 */
public class FConnexion {
    private static FConnexion fcon;
    private Facebook face;
    private FConnexion(){
        face = (Facebook) new FacebookFactory().getInstance();
        face.setOAuthAppId(ConfigModel.getProprety(Constants.FACE_ID), ConfigModel.getProprety(Constants.FACE_SECRET));
        String accessTokenString = ConfigModel.getProprety(Constants.FACE_TOKEN);
        AccessToken at = new AccessToken(accessTokenString);
        face.setOAuthAccessToken(at);
    }
    public static FConnexion getInstance(){
        if(fcon==null){
            fcon = new FConnexion();
        }
        return fcon;
    }
    public Facebook getFacebook(){
        return face;
    }
    
}
