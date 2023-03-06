package next.controller;

import javax.servlet.http.HttpSession;

import next.model.User;

import java.util.Objects;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user";

    public static User getUserFromSession(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        if (user == null) {
            return null;
        }
        return (User) user;
    }

    public static boolean isLogin(HttpSession session) {
        return getUserFromSession(session) != null;
    }

    public static boolean isSameUser(HttpSession session, User user) {
        if (!isLogin(session)) {
            return false;
        }

        if (user == null) {
            return false;
        }

        return user.isSameUser(Objects.requireNonNull(getUserFromSession(session)));
    }
}
