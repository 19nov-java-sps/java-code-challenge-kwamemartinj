package com.revature.eval;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String s = ""; //creates an empty string to hold the reversed string
		
		if(string == " ") { //checks to see if the string passed in is empty
			s = " ";
			System.out.println("Looks like your string is empty");
		}
		if(string == null) { //checks to see if string passed in is null
			return null;
		}
		else {
			//this for loop iterates thru the string passed in, from the character in the last position
			//in the string to the to the character in the first position and concatenates each character 
			//into string s to create the new reversed string 
			for(int i = string.length() -1; i>=0; i--) { 
				s = s + string.charAt(i); 
			}
			return s;
		}
	}

	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		if(phrase == null) { //checks to see if phrase passed in is null
			return null;
		}
		
		String acronym = ""; //creates an empty string to hold the acronym result
		
		//creates a string array to hold the split version of the phrase passed in
		//the phrase is split/broken wherever there is a "-", whitespace, or a special character
		//each string from the break is added to the string of arrays
		String[] splitPhrase = phrase.split("\\s|-"); 
		for(int i = 0; i < splitPhrase.length; i++) {
			acronym = acronym + splitPhrase[i].charAt(0); //the first character of each string (each word in the split phrase is concatenated and stored in acronym
		}
		return acronym.toUpperCase(); //the toUpperCase() method is used to make the final acronym ALL CAPS
		
	}
	
	
	/**
	 * 3. Given a word, compute the Scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		int points = 0; //a counter to keep track of the letter value/word score
		
		String word = string.toUpperCase(); //converts word/string passed in, to uppercase since Scrabble letters are ALLS CAPS
		
		for(int i=0; i< word.length(); i++) {
			
			if((word.charAt(i)=='A') ||(word.charAt(i)=='E') || (word.charAt(i)=='I') || (word.charAt(i)=='O') || (word.charAt(i)=='L') || (word.charAt(i)=='N') || (word.charAt(i)=='R') || (word.charAt(i)=='S') || (word.charAt(i)=='T') || (word.charAt(i)=='U')) {
				
				points = points + 1; //checks to see if the letter is either A, E, I, O, U, L, N, R, S, or T and adds 1 point if it is
				
			}
			
			else if((word.charAt(i)=='D') || (word.charAt(i)=='G')){
				points = points + 2; //checks to see if the letter is either D or G and adds 2 points if it is
			}
			
			
			if((word.charAt(i)=='B') || (word.charAt(i)=='C') || (word.charAt(i)=='M') || (word.charAt(i)=='P')) {
				
				points = points + 3; //checks to see if the letter is either B, C, M or P and adds 3 points if it is
			}
			
			else if(word.charAt(i)=='F' || word.charAt(i)=='H' || word.charAt(i)=='V'|| word.charAt(i)=='W'|| word.charAt(i)=='Y'){
				
				points = points + 4; //checks to see if the letter is either F, H, V, W, or Y and adds 4 points if it is
			}	
			
			else if(word.charAt(i)=='K') {
				
				points = points + 5; //checks to see if the letter is K and adds 5 points if it is
				
			}
			else if((word.charAt(i)=='J') || (word.charAt(i)=='X')) {
				
				points = points + 8; //checks to see if the letter is either J or X and adds 8 to it
				
			}
			else if((word.charAt(i)=='Q') || (word.charAt(i)=='Z')) {
			
			points = points + 10; //checks to see if the letter is either Q or z
			
			}
		}
	return points; //returns the total number of points/Scrabble score for the word passed in
			
 }
			

	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
		String [] wordsinPhrase =string.split("\\s*(=>|,|\\s)\\s*");
		
		LinkedHashMap<String, Integer>wordCount = new LinkedHashMap<String, Integer>();
		
		int counter = 0;
		
		for(int i=0;i<wordsinPhrase.length;i++) {
			for(int j=0;j<wordsinPhrase.length;j++) {
				
				if(wordsinPhrase[i].equals(wordsinPhrase[j])) {
					counter++;
			}
		}
			
		wordCount.put(wordsinPhrase[i], counter);
		counter = 0;
		
	}
	return wordCount;
}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int value = 0;
			
			int left = 0;
			int right = sortedList.size() - 1;
			int middle = sortedList.size()/2;
			
			if(sortedList.indexOf(t) == middle) {
				return middle;
			}
			else if(sortedList.indexOf(t) < middle) {
				for(int i=left; i<middle; i++) {
					value = sortedList.indexOf(t);
				}
			}
			else if(sortedList.indexOf(t) > middle) {
				for(int i=middle; i<right; i++) {
					value = sortedList.indexOf(t);
				}
			}
			return value;
		}
		

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}
