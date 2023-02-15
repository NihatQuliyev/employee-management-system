package util;

import exception.InvalidOption;
import service.impl.ManagementService;

public class MainUtil {
    public static void main(String[] args) throws InvalidOption {
        ManagementService managementService = new ManagementService();
        managementService.management();
    }
}
