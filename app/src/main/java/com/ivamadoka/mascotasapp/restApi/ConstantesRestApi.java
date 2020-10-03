package com.ivamadoka.mascotasapp.restApi;

public class ConstantesRestApi {

    public static final String ROOT_URL = "https://graph.instagram.com/";
    public static final String ACCESS_TOKEN = "IGQVJXUkxfQnMxTHh6dGpEQ05SNGMzdnFKaGpaZAnRHVDBmR2dCSktaRlRTT1dFZA1JfZAXB4UlAxdzJBN08tRHVacW5CRkx4ZAnpvd3ktbWVNSjAyaElDeHM1cURzNjlFSno5ZAUV3TXN3ZAzR3TEsxamZAsSQZDZD";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String KEY_FIELDS = "?fields=";
    public static final String KEY_ME = "me";
    public static final String KEY_MEDIA = "/media";
    public static final String KEY_ATRIBUTOS = "id,caption,media_type,media_url,username,like_count";

    public static final String URL_GET_MEDIA_USER = ROOT_URL + KEY_ME + KEY_MEDIA + KEY_FIELDS + KEY_ATRIBUTOS + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}
