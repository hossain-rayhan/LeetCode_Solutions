// Time: O(N) where N = length of the path
// Space: O(K) where K = unique paths
class FileSystem {
    Map<String, Integer> paths;

    public FileSystem() {
        this.paths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        // Step-1: Basic Validations
        if (path.isEmpty() || (path.length() == 1 && path.equals("/")) || this.paths.containsKey(path)) {
            return false;
        }

        int lastDirIndex = path.lastIndexOf("/");
        String parentDir = path.substring(0, lastDirIndex);

        // Step-2: If the parent doesn't exist return false
        if (parentDir.length() > 1 && !this.paths.containsKey(parentDir)) {
            return false;
        }

        // Step-3: Add this new path and return true
        this.paths.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return this.paths.getOrDefault(path, -1);
    }
}
