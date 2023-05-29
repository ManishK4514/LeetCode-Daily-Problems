class ParkingSystem {
    int[] park;
    public ParkingSystem(int big, int medium, int small) {
        park = new int[] {0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return --park[carType] >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */