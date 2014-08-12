package it.androidworld.peppeuz.feedreader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by peppeuz on 12/08/14.
 */
public class XMLParser {

    public static void parseXML (String xml)
            throws XmlPullParserException, IOException
    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(false);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(xml));

        boolean insideItem = false;

        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {

                if (xpp.getName().equalsIgnoreCase("item")) {
                    insideItem = true;
                } else if (xpp.getName().equalsIgnoreCase("title")) {
                    if (insideItem)
                        Log.i("Titolo",xpp.nextText());
                }
                else if (xpp.getName().equalsIgnoreCase("link")) {
                    if (insideItem)
                        Log.i("Link",xpp.nextText());
                }else if (xpp.getName().equalsIgnoreCase("dc:creator")) {
                    if (insideItem)
                        Log.i("Autore",xpp.nextText());
                }else if (xpp.getName().equalsIgnoreCase("description")) {
                    if (insideItem)
                        Log.i("Descrizione",xpp.nextText());
                }
            } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                insideItem = false;
            }

            eventType = xpp.next();
        }

    }
}
