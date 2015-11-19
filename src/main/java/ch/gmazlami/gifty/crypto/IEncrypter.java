package ch.gmazlami.gifty.crypto;

public interface IEncrypter {

	String encrypt(String secret, String initVector, String clearText);
}
