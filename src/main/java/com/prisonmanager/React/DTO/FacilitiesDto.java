package com.prisonmanager.React.DTO;

public class FacilitiesDto {
    public FacilitiesDto(String block, long occupied, int capacity) {
        this.block = block;
        this.occupied = occupied;
        this.capacity = capacity;
    }

    private String block;
    private long  occupied;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getOccupied() {
        return occupied;
    }

    public void setOccupied(long occupied) {
        this.occupied = occupied;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    private int capacity;
}
