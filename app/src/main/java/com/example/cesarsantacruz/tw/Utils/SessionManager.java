package com.example.cesarsantacruz.tw.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
	private static SessionManager 	s_instance 				= null;
	private static Object 		  	s_lock 					= new Object();
	
	private Context 				m_context 				= null;
	private final String 			PREFERENCES_NAME 		= "_twitterJr_preferences";
	
	private final String 			REMEMBER_PASSWORD_KEY		= "_twitterJr_remember_password";
	private final String 			REMEMBER_USER_KEY		= "_twitterJr_remember_user";
	private final String 			ACCESS_TOKEN_KEY 		= "_twitterJr_session_access_token";

	private SessionManager() {
	}

	public static SessionManager getInstace(Context context) {
		synchronized (s_lock) {
			if (s_instance == null) {
				s_instance = new SessionManager();
				s_instance.setContext(context);
			}
		}
		return s_instance;
	}
	private void setContext(Context context) {
		m_context = context;
	}
	public void setAccessToken(String token) {
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString(ACCESS_TOKEN_KEY, token);
			editor.commit();
		}
	}
	
	public String getAccessToken() {
		String result = null;
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			String accessToken = prefs.getString(ACCESS_TOKEN_KEY, null);
			if(accessToken == null) {
				accessToken = prefs.getString(ACCESS_TOKEN_KEY, "No disponible");
			}
			result = accessToken;
		}
		return result;
	}

	public void setRememberUser(String type) {
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString(REMEMBER_USER_KEY, type);
			editor.commit();
		}
	}

	public String getRememberUser() {
		String result = null;
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			String rememberUser = prefs.getString(REMEMBER_USER_KEY, null);
			if(rememberUser == null) {
				rememberUser = "";
			}
			result = rememberUser;
		}
		return result;
	}
	
	public void setRememberPassword(String type) {
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString(REMEMBER_PASSWORD_KEY, type);
			editor.commit();
		}	
	}
	
	public String getRememberPassword() {
		String result = null;
		synchronized (s_lock) {
			SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
			String accessType = prefs.getString(REMEMBER_PASSWORD_KEY, null);
			if(accessType == null) {
				accessType = "";
			}
			result = accessType;
		}
		return result;
	}
	
	public void close() {
		//													//Elimina lo contenido en el SharedPreferences
		SharedPreferences prefs = m_context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
		return;
	}
	
	
}
