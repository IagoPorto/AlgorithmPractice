class Solution(object):
    def uniqueOccurrences(self,arr):
        # Contar las ocurrencias
        numberOccurrences = {}
        for num in arr:
            numberOccurrences[num] = numberOccurrences.get(num, 0) + 1

        # Verificar si las frecuencias son únicas
        occurrences = set()
        for count in numberOccurrences.values():
            if count in occurrences:
                return False
            occurrences.add(count)
        
        return True
