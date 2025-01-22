package Backend.User_Management.dtos;

import jakarta.persistence.Column;

public class UserDto {
    private Long id;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserDto(Long id, String fullName, String email, String position) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.position = position;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
