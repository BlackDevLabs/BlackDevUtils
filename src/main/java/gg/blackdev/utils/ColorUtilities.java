package gg.blackdev.utils;

public class ColorUtilities {

    // ========== RGB to Hex ==========
    /**
     * Converts RGB values to a hex string (#RRGGBB).
     *
     * @param red The red component (0-255)
     * @param green The green component (0-255)
     * @param blue The blue component (0-255)
     * @return A string representing the hex color (#RRGGBB)
     */
    public static String rgbToHex(int red, int green, int blue) {
        // Ensure the RGB values are valid
        validateRGB(red, green, blue);
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    // ========== Hex to RGB ==========
    /**
     * Converts a hex color (#RRGGBB) to an RGB array.
     *
     * @param hexColor The hex color string (#RRGGBB)
     * @return An array containing RGB values [R, G, B]
     * @throws IllegalArgumentException If the hex color is invalid
     */
    public static int[] hexToRGB(String hexColor) {
        // Remove the hash symbol if present
        if (hexColor.startsWith("#")) {
            hexColor = hexColor.substring(1);
        }

        // Ensure the hex string is valid
        if (hexColor.length() != 6) {
            throw new IllegalArgumentException("Hex color should be in RRGGBB format.");
        }

        // Parse the red, green, and blue values from the hex string
        int red = Integer.parseInt(hexColor.substring(0, 2), 16);
        int green = Integer.parseInt(hexColor.substring(2, 4), 16);
        int blue = Integer.parseInt(hexColor.substring(4, 6), 16);

        return new int[] { red, green, blue };
    }

    // ========== RGB to Hex Integer ==========
    /**
     * Converts RGB values to a packed hex integer (0xRRGGBB).
     *
     * @param red The red component (0-255)
     * @param green The green component (0-255)
     * @param blue The blue component (0-255)
     * @return The packed hex integer (0xRRGGBB)
     */
    public static int rgbToHexInt(int red, int green, int blue) {
        validateRGB(red, green, blue);
        return (red << 16) | (green << 8) | blue;
    }

    // ========== Hex to Hex Integer ==========
    /**
     * Converts a hex color (#RRGGBB) to a packed hex integer (0xRRGGBB).
     *
     * @param hexColor The hex color string (#RRGGBB)
     * @return The packed hex integer (0xRRGGBB)
     */
    public static int hexToHexInt(String hexColor) {
        int[] rgb = hexToRGB(hexColor);
        return rgbToHexInt(rgb[0], rgb[1], rgb[2]);
    }

    // ========== Hex Integer to Hex ==========
    /**
     * Converts a packed hex integer (0xRRGGBB) to a hex string (#RRGGBB).
     *
     * @param hexInt The packed hex integer (0xRRGGBB)
     * @return A string representing the hex color (#RRGGBB)
     */
    public static String hexIntToHex(int hexInt) {
        return String.format("#%06X", hexInt & 0xFFFFFF);
    }

    // ========== Hex Integer to RGB ==========
    /**
     * Converts a packed hex integer (0xRRGGBB) to an RGB array.
     *
     * @param hexInt The packed hex integer (0xRRGGBB)
     * @return An array containing RGB values [R, G, B]
     */
    public static int[] hexIntToRGB(int hexInt) {
        int red = (hexInt >> 16) & 0xFF;
        int green = (hexInt >> 8) & 0xFF;
        int blue = hexInt & 0xFF;
        return new int[] { red, green, blue };
    }

    // ========== Helper Method ==========
    /**
     * Validates the RGB values to ensure they are between 0 and 255.
     *
     * @param red The red component
     * @param green The green component
     * @param blue The blue component
     * @throws IllegalArgumentException If any value is out of range
     */
    private static void validateRGB(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("RGB values must be between 0 and 255.");
        }
    }
}
