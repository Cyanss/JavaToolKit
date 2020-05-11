package cyan.tool.kit.chip.starter.flux.security;

import com.sun.deploy.util.ArrayUtil;
import cyan.tool.kit.chip.core.contant.EncodingConstant;
import cyan.tool.kit.chip.core.error.RiceException;
import cyan.tool.kit.chip.starter.error.*;
import cyan.tool.kit.chip.starter.util.common.HexUtils;
import cyan.tool.kit.chip.starter.util.supply.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.SpringApplication;
import sun.nio.cs.ext.GBK;
import sun.plugin2.message.Message;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * <p>RiceCipherUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:03 2020/1/17
 */
@Slf4j
public class CipherFluxes {
    public final static String SECRET_KEY = "DES";
    public final static String DEFAULT_KEY = "NILEADER";
    public final static String ALGORITHM = "DES/CBC/PKCS5Padding";
    public final static String URL_DECODER = EncodingConstant.UTF8;
    public final static String CRYPT_DECODER = EncodingConstant.UTF8;

    public static String decrypt(String message) throws RiceException {
        byte[] messageBytes = HexUtils.parse(message);
        Cipher decrypt = decrypt();
        byte[] cipherBytes = cipher(decrypt, messageBytes);
        return encode(new String(cipherBytes),URL_DECODER);
    }

    public static Cipher decrypt() throws RiceException {
        byte[] keyBytes = decode(DEFAULT_KEY,CRYPT_DECODER);
        SecretKey secretKey = secretKey(keyBytes,SECRET_KEY);
        Cipher cipher = cipher(ALGORITHM);
        cipher(cipher,Cipher.DECRYPT_MODE, secretKey,keyBytes);
        return cipher;
    }

    public static String encrypt(String message) throws RiceException{
        String encode = encode(message, URL_DECODER);
        byte[] messageBytes = decode(encode,CRYPT_DECODER);
        Cipher encrypt = encrypt();
        byte[] bytes = cipher(encrypt,messageBytes);
        return HexUtils.parse(bytes);
    }

    public static Cipher encrypt() throws RiceException {
        byte[] keyBytes = decode(DEFAULT_KEY,CRYPT_DECODER);
        SecretKey secretKey = secretKey(keyBytes, SECRET_KEY);
        Cipher cipher = cipher(ALGORITHM);
        cipher(cipher, Cipher.ENCRYPT_MODE, secretKey, keyBytes);
        return cipher;
    }

    private static Cipher cipher(String cipherAlgorithm) throws CryptException {
        try {
            return Cipher.getInstance(cipherAlgorithm);
        } catch (NoSuchPaddingException e) {
            throw new CryptException(e.getMessage(), CryptErrorStatus.CRYPT_ALGORITHM_ERROR);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e.getMessage(), CryptErrorStatus.CRYPT_ALGORITHM_INVALID);
        }
    }

    private static byte[] cipher(Cipher cipher, byte[] bytes) throws CryptException {
        try {
            return cipher.doFinal(bytes);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptException(e.getMessage(), CryptErrorStatus.CRYPT_ALGORITHM_ERROR);
        }
    }

    private static void cipher(Cipher cipher, int model,SecretKey secretKey, byte[] bytes) throws CryptException, SecretKeyException {
        try {
            cipher.init(model, secretKey, new IvParameterSpec(bytes));
        } catch (InvalidKeyException e) {
            throw new SecretKeyException(e.getMessage(), SecretKeyErrorStatus.SECRET_KEY_INVALID);
        } catch (InvalidAlgorithmParameterException e) {
            throw new CryptException(e.getMessage(), CryptErrorStatus.CRYPT_ALGORITHM_INVALID);
        }
    }

    private static SecretKey secretKey(byte[] keyBytes, String secretKey) throws CryptException, SecretKeyException {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(secretKey);
            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            return keyFactory.generateSecret(desKeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e.getMessage(), CryptErrorStatus.CRYPT_ALGORITHM_INVALID);
        } catch (InvalidKeyException | InvalidKeySpecException e) {
            throw new SecretKeyException(e.getMessage(), SecretKeyErrorStatus.SECRET_KEY_INVALID);
        }
    }

    private static byte[] decode(String target, String encoding) throws CodingException {
        try {
            return target.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            throw new CodingException(e.getMessage(), CodingErrorStatus.ENCODING_INVALID);
        }
    }


    private static String encode(String target,String encoding) throws CodingException {
        try {
            return java.net.URLEncoder.encode(target, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new CodingException(e.getMessage(), CodingErrorStatus.ENCODING_INVALID);
        }
    }
}
