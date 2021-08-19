package com.bluntsoftware.events.util.hot;

import java.io.File;

public interface HotFolderListener {
    void onChange(File file);
}
