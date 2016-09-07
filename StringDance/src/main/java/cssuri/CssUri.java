package cssuri;

import com.google.common.io.Files;
import org.codehaus.plexus.util.Base64;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;



public class CssUri {

    /** directories where to look for images from */
    private File[] imagesDir;

    private static Pattern pattern = Pattern.compile("[\\s'\":/\\\\]+");

    private static final int SIZE_LIMIT = 32 * 1024;

    private static final Map<String, String> supportedTypes = new HashMap<String, String>();

    static {
        supportedTypes.put("gif", "image/gif");
        supportedTypes.put("jpg", "image/jpeg");
        supportedTypes.put("jpeg", "image/jpeg");
        supportedTypes.put("png", "image/png");
    }

    public CssUri(final File[] imagesDir) {
        this.imagesDir = imagesDir;
    }

    public String resolveToken(final String token) throws IOException {
        if (token == null || token.length() < 1) {
            return token;
        }

        String[] pathParts = pattern.split(token);
        if (pathParts == null || pathParts.length < 1) {
            return null;
        }

        final String separator = System.getProperty("file.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(separator);

        for (int i = 0; i < pathParts.length; i++) {
            if (StringUtils.isNotBlank(pathParts[i])) {
                sb.append(pathParts[i]);
                if (i + 1 < pathParts.length) {
                    sb.append(separator);
                }
            }
        }

        String path = sb.toString();
        if (path.length() == 1) {
            return null;
        }

        if (path.endsWith(separator)) {
            path = path.substring(0, path.length() - 1);
        }

        // build image full path and check if image exists and has supported mime-type
        boolean found = false;
        File imageFile = null;
        String extension = null;
        for (File imageDir : imagesDir) {
            String fullPath = imageDir.getCanonicalPath() + path;

            imageFile = new File(fullPath);
            if (!imageFile.exists()) {
                // file doesn't exist
                continue;
            }

            extension = FileUtils.extension(fullPath);
            if (extension == null || !supportedTypes.containsKey(extension)) {
                // not supported image mime-type
                continue;
            }

            found = true;

            break;
        }

        if (!found) {
            return null;
        }

        // generate dataURI
        final byte[] bytes = Files.toByteArray(imageFile);
        StringBuilder dataUriBilder = new StringBuilder();
        dataUriBilder.append("data:");
        dataUriBilder.append(supportedTypes.get(extension));
        dataUriBilder.append(";base64,");
        dataUriBilder.append(new String(Base64.encodeBase64(bytes)));

        String dataUri = dataUriBilder.toString();

        // Check if the size of dataURI is limited to 32KB (because IE8 has a 32KB limitation)
        boolean exceedLimit = dataUri.length() >= SIZE_LIMIT;
        if (exceedLimit) {
            return null;
        }

        return dataUri;
    }

    public static void main(String[] args){
        File[] files = new File[1];
        final String sp = System.getProperty("file.separator");
        String path = "C:"+sp+"JTalks"+sp+"jcommune"+sp+"jcommune-view"+sp+"jcommune-web-view"+sp+"src"+sp+"main"+sp+"webapp"+sp+"resources";
        files[0] = new File(path);
        CssUri cssuri = new CssUri(files);
        try {
            cssuri.resolveToken("/images/fabric-plaid.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
