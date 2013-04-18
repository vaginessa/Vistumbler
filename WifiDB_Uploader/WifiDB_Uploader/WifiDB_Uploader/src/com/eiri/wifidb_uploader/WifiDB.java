package com.eiri.wifidb_uploader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class WifiDB {
	public void postLiveData(String sSID, String bSSID, String capabilities, Integer frequency, Integer level, String latitude_str, String longitude_str) {
	    // Create a new HttpClient and Post Header
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://dev01.wifidb.net/wifidb/api/live.php");
	    String Found_AUTH = "";
	    String Found_ENCR = "";
	    Integer Found_SecType = 0;
        Integer chan = 0;
        String radio = "";
	    String nt = "";
	    //convert to vs1/wifidb data
	    if(capabilities.contains("WPA2-PSK-CCMP") || capabilities.contains("WPA2-PSK-TKIP+CCMP"))
        {	
	    	Found_AUTH = "WPA2-Personal";
            Found_ENCR = "CCMP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA-PSK-CCMP") || capabilities.contains("WPA-PSK-TKIP+CCMP"))
        {	
        	Found_AUTH = "WPA-Personal";
            Found_ENCR = "CCMP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA2-EAP-CCMP") || capabilities.contains("WPA2-EAP-TKIP+CCMP"))
        {	
        	Found_AUTH = "WPA2-Enterprise";
            Found_ENCR = "CCMP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA-EAP-CCMP") || capabilities.contains("WPA-EAP-TKIP+CCMP"))
        {
        	Found_AUTH = "WPA-Enterprise";
            Found_ENCR = "CCMP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA2-PSK-TKIP"))
        {	
        	Found_AUTH = "WPA2-Personal";
            Found_ENCR = "TKIP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA-PSK-TKIP"))
        {	
        	Found_AUTH = "WPA-Personal";
            Found_ENCR = "TKIP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA2-EAP-TKIP"))
        {	
        	Found_AUTH = "WPA2-Enterprise";
            Found_ENCR = "TKIP";
            Found_SecType = 3;
        }else if(capabilities.contains("WPA-EAP-TKIP"))
        {	
        	Found_AUTH = "WPA-Enterprise";
            Found_ENCR = "TKIP";
            Found_SecType = 3;
        }else if(capabilities.contains("WEP"))
        {	
        	Found_AUTH = "Open";
            Found_ENCR = "WEP";
            Found_SecType = 2;
        }else
        {	
        	Found_AUTH = "Open";
            Found_ENCR = "None";
            Found_SecType = 1;
        }
        if(capabilities.contains("IBSS"))
        {
            nt = "Ad-Hoc";
        }else
        {
            nt = "Infrastructure";
        }
        
        switch(frequency)
        {
            case 2412:
                chan = 1;
                radio = "802.11g";
            break;
            case 2417:
                chan = 2;
                radio = "802.11g";
            break;
            case 2422:
                chan = 3;
                radio = "802.11g";
            break;
            case 2427:
                chan = 4;
                radio = "802.11g";
            break;
            case 2432:
                chan = 5;
                radio = "802.11g";
            break;
            case 2437:
                chan = 6;
                radio = "802.11g";
            break;
            case 2442:
                chan = 7;
                radio = "802.11g";
            break;
            case 2447:
                chan = 8;
                radio = "802.11g";
            break;
            case 2452:
                chan = 9;
                radio = "802.11g";
            break;
            case 2457:
                chan = 10;
                radio = "802.11g";
            break;
            case 2462:
                chan = 11;
                radio = "802.11g";
            break;
            case 2467:
                chan = 12;
                radio = "802.11g";
            break;
            case 2472:
                chan = 13;
                radio = "802.11g";
            break;
            case 2484:
                chan = 14;
                radio = "802.11g";
            break;
            case 5180:
            	chan = 36;
            	radio = "802.11n";
        	break;
            case 5200:
            	chan = 40;
            	radio = "802.11n";
        	break;
            case 5220:
            	chan = 44;
            	radio = "802.11n";
        	break;
            case 5240:
            	chan = 48;
            	radio = "802.11n";
        	break;
            case 5260:
            	chan = 52;
            	radio = "802.11n";
        	break;
            case 5280:
            	chan = 56;
            	radio = "802.11n";
        	break;
            case 5300:
            	chan = 60;
            	radio = "802.11n";
        	break;
            case 5320:
            	chan = 64;
            	radio = "802.11n";
        	break;
            case 5500:
            	chan = 100;
            	radio = "802.11n";
        	break;
            case 5520:
            	chan = 104;
            	radio = "802.11n";
        	break;
            case 5540:
            	chan = 108;
            	radio = "802.11n";
        	break;
            case 5560:
            	chan = 112;
            	radio = "802.11n";
        	break;
            case 5580:
            	chan = 116;
            	radio = "802.11n";
        	break;
            case 5600:
            	chan = 120;
            	radio = "802.11n";
        	break;
            case 5620:
            	chan = 124;
            	radio = "802.11n";
        	break;
            case 5640:
            	chan = 128;
            	radio = "802.11n";
        	break;
            case 5660:
            	chan = 132;
            	radio = "802.11n";
        	break;
            case 5680:
            	chan = 136;
            	radio = "802.11n";
        	break;
            case 5700:
            	chan = 140;
            	radio = "802.11n";
        	break;
            case 5745:
            	chan = 149;
            	radio = "802.11n";
        	break;
            case 5765:
            	chan = 153;
            	radio = "802.11n";
        	break;
            case 5785:
            	chan = 157;
            	radio = "802.11n";
        	break;
            case 5805:
            	chan = 161;
            	radio = "802.11n";
        	break;
            case 5825:
            	chan = 165;
            	radio = "802.11n";
        	break;
            default:
                chan = 6;
                radio = "802.11g";
            break;
        }
	    
	    // Upload your data, muahahahahaha
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("ssid", sSID));
        nameValuePairs.add(new BasicNameValuePair("mac", bSSID));
        nameValuePairs.add(new BasicNameValuePair("auth", Found_AUTH));
        nameValuePairs.add(new BasicNameValuePair("encry", Found_ENCR));
        nameValuePairs.add(new BasicNameValuePair("sectype", Integer.toString(Found_SecType)));
        nameValuePairs.add(new BasicNameValuePair("chan", Integer.toString(chan)));
        nameValuePairs.add(new BasicNameValuePair("radio", radio));
        nameValuePairs.add(new BasicNameValuePair("nt", nt));
        nameValuePairs.add(new BasicNameValuePair("signal", Integer.toString(level)));
        nameValuePairs.add(new BasicNameValuePair("latitude", latitude_str));
        nameValuePairs.add(new BasicNameValuePair("longitude", longitude_str));
        
        try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Execute HTTP Post Request
        try {
			HttpResponse response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
				Log.d("", "HTTP Receive message: " + EntityUtils.toString(entity));
            }			

			
	    } catch (UnsupportedEncodingException uee) {
	        Log.d("Exceptions", "UnsupportedEncodingException");
	        uee.printStackTrace();
	    } catch (ClientProtocolException cpe) {
	        Log.d("Exceptions", "ClientProtocolException");
	        cpe.printStackTrace();
	    } catch (IOException ioe) {
	        Log.d("Exceptions", "IOException");
	        ioe.printStackTrace();
	    }  
	} 
	// see http://androidsnippets.com/executing-a-http-post-request-with-httpclient
}