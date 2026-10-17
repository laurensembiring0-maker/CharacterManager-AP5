
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {
        if (character == null || character.getName() == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Gagal: karakter dengan nama '"
                + character.getName() + "' sudah ada!"
            );
            return false;
        }

        characters.add(character);
        System.out.println(
            "Karakter '" + character.getName()
            + "' berhasil ditambahkan."
        );
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {
        
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName() != null
                    && character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            System.out.println(
                "Karakter '" + name + "' tidak ditemukan."
            );
            return false;
        }

        characters.remove(character);
        System.out.println(
            "Karakter '" + character.getName() + "' berhasil dihapus."
        );
        return true;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level karakter
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    /**
     * Mengambil semua karakter berdasarkan jenisnya.
     * @param type jenis karakter yang dicari
     * @return daftar baru karakter dengan jenis tersebut
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan level tertinggi.
     * @return karakter dengan level tertinggi, atau null jika kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }

    /**
     * Mengganti nama karakter jika nama baru belum digunakan.
     * @param oldName nama karakter saat ini
     * @param newName nama baru
     * @return true jika berhasil, false jika gagal
     */
    public boolean renameCharacter(String oldName, String newName) {
        if (oldName == null || newName == null
                || oldName.trim().isEmpty()
                || newName.trim().isEmpty()) {
            return false;
        }

        Character target = findByName(oldName.trim());

        if (target == null) {
            return false;
        }

        String cleanName = newName.trim();
        Character existing = findByName(cleanName);

        if (existing != null && existing != target) {
            return false;
        }

        target.setName(cleanName);
        return true;
    }
}
