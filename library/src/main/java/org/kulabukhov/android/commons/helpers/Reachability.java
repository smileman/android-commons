package org.kulabukhov.android.commons.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * A utility class for determining network availability.
 */
public class Reachability {

	/**
	 * Types of network connection
	 */
	public enum ConnectStatus {
		CONNECT_OFF,
		CONNECT_WIFI,
		CONNECT_3G
	};

	/**
	 * A convenience method for retrieving the ConnectivityManager in a given
	 * context.
	 *
	 * @param context
	 * @return the ConnectivityManager instance for the given context.
	 */
	public static ConnectivityManager getConnectivityManager(Context context) {
		return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	/**
	 * A convenience method for retrieving the {@link NetworkInfo} for the
	 * currently active network.
	 *
	 * @param context
	 * @return a {@link NetworkInfo} instance for the currently active network.
	 */
	public static NetworkInfo getActiveNetworkInfo(Context context) {
		return getConnectivityManager(context).getActiveNetworkInfo();
	}

	/**
	 * A convenience method for determining if networking is available for the
	 * currently active network connection.
	 *
	 * @param context
	 * @return true if and only if the currently active network is available and
	 * connected.
	 */
	public static boolean isNetworkingAvailable(Context context) {
		NetworkInfo networkInfo = getActiveNetworkInfo(context);
		if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns type of current network connection
	 * @param context
	 * @return type of current network connection
	 * @see org.kulabukhov.android.commons.helpers.Reachability.ConnectStatus
	 */
	public static ConnectStatus getConnectStatus(Context context) {
		ConnectivityManager manager = getConnectivityManager(context);

		//For 3G check
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		boolean is3g = networkInfo != null && networkInfo.isConnectedOrConnecting();

		//For WiFi Check
		networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		boolean isWifi = networkInfo != null && networkInfo.isConnectedOrConnecting();

		if (!is3g && !isWifi) {
			return ConnectStatus.CONNECT_OFF;
		} else if (is3g) {
			return ConnectStatus.CONNECT_3G;
		} else {
			return ConnectStatus.CONNECT_WIFI;
		}
	}
}
