package com.tikfind.inheritance;

public class Admin extends Pengguna {
    private String department;

    public Admin(String nama, String kontak, String department) {
        super(nama, kontak);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String getRoleDescription() {
        return "Admin of department: " + department;
    }
}
