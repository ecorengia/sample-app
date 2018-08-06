package com.ecorengia.org.cinemaapp.networking.ssl;

import android.support.annotation.NonNull;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import timber.log.Timber;

/**
 * Trust Manager that provides support for self-signed certificates.
 *
 * @author ecorengia
 */
public final class SelfX509TrustManager implements CinemaTrustManager {

    private X509TrustManager mX509TrustManager;

    public SelfX509TrustManager() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        // Get the trust manager factory and initialize it
        final TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
        } catch (@NonNull final NoSuchAlgorithmException | KeyStoreException e) {
            Timber.e(e, "Cannot initialize TrustManager: %s.", e.getLocalizedMessage());
            throw e;
        }
        // Get all the trust managers and find the X509 trust manager
        final TrustManager[] managers = trustManagerFactory.getTrustManagers();
        for (final TrustManager trustManager : managers) {
            if (trustManager instanceof X509TrustManager) {
                mX509TrustManager = (X509TrustManager) trustManager;
                break;
            }
        }
        if (mX509TrustManager == null) {
            throw new KeyManagementException("Cannot find a valid X509 trust manager.");
        }
    }

    @Override
    public void checkClientTrusted(@NonNull final X509Certificate[] chain, @NonNull final String type)
            throws CertificateException {
        throw new CertificateException();
    }

    @Override
    public void checkServerTrusted(@NonNull final X509Certificate[] chain, @NonNull final String type)
            throws CertificateException {
        // Use X509 trust manager to determine if this certificate should be trusted or not
        try {
            mX509TrustManager.checkServerTrusted(chain, type);
        } catch (@NonNull final CertificateException e) {
            Timber.e(e, "CERTIFICATE CAN'T BE VALIDATED OR ISN'T TRUSTED: %s.",
                    e.getLocalizedMessage());
            // Propagate exception so it's reported later on
            throw e;
        }
        Timber.d("Certificate %s is trusted.", type);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return mX509TrustManager.getAcceptedIssuers();
    }
}
