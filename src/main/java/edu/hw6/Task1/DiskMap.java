package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final Map<String, String> map;
    private final Path path;

    public DiskMap(String path) {
        this.path = Paths.get(path);
        this.map = new HashMap<>();
        this.loadFile();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        var result = map.put(key, value);
        this.save();
        return result;
    }

    @Override
    public String remove(Object key) {
        var result = map.remove(key);
        this.save();
        return result;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path.toFile()))) {
            for (var entry : this.map.entrySet()) {
                String s = entry.getKey() + ":" + entry.getValue() + "\n";
                writer.write(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadFile() {
        File file = this.path.toFile();
        try (var br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                var keyVal = line.split(":");
                if (keyVal.length != 2) {
                    throw new RuntimeException("Invalid file");
                }
                this.map.put(keyVal[0], keyVal[1]);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
