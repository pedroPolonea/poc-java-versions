package vo;

import java.util.List;
import java.util.Objects;

public class AuthorVO {
    private String group;
    private List<String> name;

    public AuthorVO() {
    }

    public AuthorVO(String group, List<String> name) {
        this.group = group;
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorVO{" +
                "group='" + group + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorVO authorVO = (AuthorVO) o;
        return Objects.equals(group, authorVO.group) &&
                Objects.equals(name, authorVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, name);
    }
}
