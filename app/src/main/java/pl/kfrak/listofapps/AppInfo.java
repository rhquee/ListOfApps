package pl.kfrak.listofapps;


import android.graphics.drawable.Drawable;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data

public class AppInfo {
    //ta klasa jest holderem/trzymaczem tego co dostaniemy od ...?

    private final int uid;
    private final String name;
    private final Drawable icon;

    }
