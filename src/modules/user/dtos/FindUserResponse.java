package modules.user.dtos;

public final class FindUserResponse {
    private final String id;
    private final String name;

    public FindUserResponse(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public String id() { return id; }

    public String name() { return name; }
}
