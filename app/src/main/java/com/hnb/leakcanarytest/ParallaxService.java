package com.hnb.leakcanarytest;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by USER on 7/8/2015.
 */
public class ParallaxService extends IntentService
{

    // action
    public static final String ACTION_GET_DEAL_LONG_TERM = "ACTION_GET_DEAL_LONG_TERM";
    public static final String ACTION_GET_COMMENT_BY_DEAL_ID = "ACTION_GET_COMMENT_BY_DEAL_ID";
    public static final String ACTION_GET_DEAL_CLAIMED = "ACTION_GET_DEAL_CLAIMED";

    // receiver
    public static final String RECEIVER_GET_DEAL_LONG_TERM = "RECEIVER_GET_DEAL_LONG_TERM";
    public static final String RECEIVER_GET_COMMENT_BY_DEAL_ID = "RECEIVER_GET_COMMENT_BY_DEAL_ID";
    public static final String RECEIVER_GET_DEAL_CLAIMED = "RECEIVER_GET_DEAL_CLAIMED";

    // extra code and result value
    public static final String EXTRA_RESULT = "EXTRA_RESULT";
    public static final String RESULT_OK = "RESULT_OK";
    public static final String RESULT_FAIL = "RESULT_FAIL";
    public static final String RESULT_NO_INTERNET = "RESULT_NO_INTERNET";

    public static final String EXTRA_RESULT_MESSAGE = "EXTRA_RESULT_MESSAGE";
    public static String RESULT_MESSAGE = "";
    public static final String EXTRA_RESULT_LAST_PAGE = "EXTRA_RESULT_LAST_PAGE";
    public static String RESULT_LAST_PAGE = "0";

    public static final String EXTRA_LATITUDE = "EXTRA_LATITUDE";
    public static final String EXTRA_LONGITUDE = "EXTRA_LONGITUDE";
    public static final String EXTRA_PAGE = "EXTRA_PAGE";
    public static final String EXTRA_DEAL_ID = "EXTRA_DEAL_ID";
    public static final String EXTRA_CONSUMER_ID = "EXTRA_CONSUMER_ID";

    public static final String ACTION_SEARCH_DEAL = "ACTION_SEARCH_DEAL";
    public static final String RECEIVER_SEARCH_DEAL = "RECEIVER_SEARCH_DEAL";
    public static final String EXTRA_FOLLOWING_ID = "EXTRA_FOLLOWING_ID";
    public static final String EXTRA_KEYWORD = "EXTRA_KEYWORD";
    public static final String EXTRA_DEAL_TYPE = "EXTRA_DEAL_TYPE";
    public static final String EXTRA_DISCOVERY_TYPE = "EXTRA_DISCOVERY_TYPE";
    public static final String EXTRA_DISCOVERY_ID = "EXTRA_DISCOVERY_ID";
    public static final String EXTRA_MIN = "EXTRA_MIN";
    public static final String EXTRA_MAX = "EXTRA_MAX";

    public ParallaxService()
    {
        super(ParallaxService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        String action = intent.getAction();

        if (action.equals(ACTION_GET_DEAL_LONG_TERM))
        {
            sendBroadCastReceiver(RECEIVER_GET_DEAL_LONG_TERM, RESULT_OK, RESULT_MESSAGE);
        }

    }

    private void sendBroadCastReceiver(String action, String result, String message)
    {
        Intent i = new Intent();
        i.setAction(action);
        i.putExtra(ParallaxService.EXTRA_RESULT, result);
        i.putExtra(ParallaxService.EXTRA_RESULT_MESSAGE, message);
        RESULT_MESSAGE = "";
        if (action.equals(RECEIVER_GET_DEAL_LONG_TERM))
        {
            i.putExtra(ParallaxService.EXTRA_RESULT_LAST_PAGE, RESULT_LAST_PAGE);
            RESULT_LAST_PAGE = "0";
        }
        sendBroadcast(i);
    }


}
