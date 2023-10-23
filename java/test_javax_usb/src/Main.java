public class Main {
    public static void main(String[] args) {
        UsbServices services = UsbHostManager.getUsbServices();

        try {
            UsbHub rootHub = services.getRootUsbHub();
            listDevices(rootHub);
        } catch (UsbException e) {
            e.printStackTrace();
        }
    }

    public static void listDevices(UsbHub hub) throws UsbException {
        List<UsbDevice> devices = hub.getAttachedUsbDevices();
        for (UsbDevice device : devices) {
            System.out.println("Device Descriptor: " + device.getUsbDeviceDescriptor());
            System.out.println("Product Name: " + device.getProductString());
            System.out.println("Manufacturer Name: " + device.getManufacturerString());

            if (device.isUsbHub()) {
                listDevices((UsbHub) device);
            }
        }
    }
}