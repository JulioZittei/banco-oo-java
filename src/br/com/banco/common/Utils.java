package br.com.banco.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	
	public static String capitalize(String texto) {
		String[] palavras = texto.split("\\s");
	    StringBuilder sb = new StringBuilder();

	    for(int i = 0; i < palavras.length; i++){
	        sb.append(palavras[i].substring(0, 1).toUpperCase() + palavras[i].substring(1).toLowerCase());
	        sb.append(" ");
	    }

	    return sb.toString();
		
	}
	
	public static boolean matches(String regex, String texto) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}
	
	public static LocalDate toLocalDate(String data, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, new Locale("pt", "BR"));
		return LocalDate.parse(data, formatter);
	}
	
	public static OffsetDateTime toOffsetDateTime(String data, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, new Locale("pt", "BR"));
		return LocalDateTime.parse(data, formatter).atOffset(ZoneOffset.ofHours(-3));
	}
	
	public static String toString(OffsetDateTime data, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, new Locale("pt", "BR"));
		return formatter.format(data);
	}
	
	public static String toString(LocalDate data, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, new Locale("pt", "BR"));
		return formatter.format(data);
	}
	
}
