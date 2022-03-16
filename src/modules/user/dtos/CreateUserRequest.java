package modules.user.dtos;

public final class CreateUserRequest {
    private final String id;
    private final String name;

    public CreateUserRequest(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public String id() { return id; }

    public String name() { return name; }
}
