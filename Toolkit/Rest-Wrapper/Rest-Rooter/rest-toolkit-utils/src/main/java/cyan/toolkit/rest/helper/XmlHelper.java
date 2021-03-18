package cyan.toolkit.rest.helper;

import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.error.natives.ResourceErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <p>XmlHelper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2019/12/26
 */
public class XmlHelper {

    private static final String XML_HEADERS_KEY = "com.sun.xml.internal.bind.xmlHeaders";
    private static final String XML_HEADERS_VALUE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String XML_DECLARATION = "com.sun.xml.internal.bind.xmlDeclaration";

    public static <T> Marshaller marshaller(Class<T> type) throws RestException {
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
            return marshaller;
        } catch (JAXBException exception) {
            exception.printStackTrace();
            String message = "JAXB资源访问错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        }

    }

    public static void header(String name, String ext, HttpServletResponse response) throws RestException {
        try {
            String filename = URLEncoder.encode(name, "UTF-8");
            String content = "attachment;filename=".concat(filename).concat(ext);
            response.setHeader("Content-Disposition", content);
            response.setHeader("ContentType", "application/xml;charset=UTF-8");
            response.setContentType("application/octet-stream");
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            String message = "文件名转换[UTF-8]编码错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        }
    }

    public static <T> void write(T xmlBean, String name, String ext, HttpServletResponse response) throws RestException {
        try {
            header(name, ext, response);
            JAXBContext context = JAXBContext.newInstance(xmlBean.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(XML_HEADERS_KEY, XML_HEADERS_VALUE);
            marshaller.setProperty(XML_DECLARATION, Boolean.FALSE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            ServletOutputStream outputStream = response.getOutputStream();
            marshaller.marshal(xmlBean,outputStream);
        } catch (JAXBException exception) {
            exception.printStackTrace();
            String message = "JAXB资源访问错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        } catch (IOException exception) {
            exception.printStackTrace();
            String message = "Response资源访问错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        }

    }

    public static <T> T unMarshal(MultipartFile xmlFile, Class<T> type) throws RestException {
        try {
            InputStream inputStream = xmlFile.getInputStream();
            return JAXB.unmarshal(inputStream, type);
        } catch (DataBindingException exception) {
            exception.printStackTrace();
            String message = "JAXB解析Xml文件错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        } catch (IOException exception) {
            exception.printStackTrace();
            String message = "Xml文件访问错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        }
    }

    public static <T> void marshal(T xmlBean,String name, String ext, HttpServletResponse response) throws RestException {
        try {
            header(name,ext,response);
            ServletOutputStream outputStream = response.getOutputStream();
            JAXB.marshal(xmlBean,outputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            String message = "Response资源访问错误, error: ".concat(exception.getMessage());
            throw new ResourceErrorException(message);
        }
    }

}
