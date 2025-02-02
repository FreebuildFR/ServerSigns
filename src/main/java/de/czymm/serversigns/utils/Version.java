package de.czymm.serversigns.utils;

public enum Version {
    CURRENT(0, 0),
    V1_7(1, 7),
    V1_8(1, 8),
    V1_9(1, 9),
    V1_10(1, 10),
    V1_11(1, 11),
    V1_12(1, 12),
    V1_13(1, 13),
    V1_14(1, 14),
    V1_15(1, 15),
    V1_16(1, 16);

    private int major;
    private int minor;

    Version(final int major, final int minor) {
        this.major = major;
        this.minor = minor;
    }

    private void updateVersion(final String strVersion) {
        final String[] splitVersion = strVersion.split("\\.");

        if (splitVersion.length >= 2) {
            major = Integer.parseInt(splitVersion[0]);
            minor = Integer.parseInt(splitVersion[1]);
        }
    }

    public static void initVersion(final String strVersion) {
        Version.CURRENT.updateVersion(strVersion);
    }

    public static boolean isLowerThan(final Version newVersion) {
        return (CURRENT.minor < newVersion.minor && CURRENT.major == newVersion.major) || CURRENT.major < newVersion.major;
    }

    public static boolean isLowerOrEqualsTo(final Version newVersion) {
        return (CURRENT.minor == newVersion.minor && CURRENT.major == newVersion.major) ||
            ((CURRENT.minor < newVersion.minor && CURRENT.major == newVersion.major) || CURRENT.major < newVersion.major);
    }

    public static boolean isEqualsTo(final Version newVersion) {
        return CURRENT.minor == newVersion.minor && CURRENT.major == newVersion.major;
    }

    public static boolean isHigherOrEqualsTo(final Version newVersion) {
        return (CURRENT.minor == newVersion.minor && CURRENT.major == newVersion.major) ||
            ((CURRENT.minor > newVersion.minor && CURRENT.major == newVersion.major) || CURRENT.major > newVersion.major);
    }

    public static boolean isHigherThan(final Version newVersion) {
        return  (CURRENT.minor > newVersion.minor && CURRENT.major == newVersion.major) || CURRENT.major > newVersion.major;
    }
}
