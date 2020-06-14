// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomFact() {
  const randomFacts =
      ['I like to code.', 
       'Soccer is my favorite sport.', 
       'My favorite color is blue.', 
       'I live in Mexico.'];

  // Pick a random greeting.
  const randomFact = randomFacts[Math.floor(Math.random() * randomFacts.length)];

  // Add it to the page.
  document.getElementById('random-facts-container').innerText = randomFact;
}

function displayComments() {
  fetch('/data')
  .then(response => response.json())
  .then((commentArray) => {
    
    const commentList = document.getElementById('comments-container');
    commentList.innerHTML = '';
    
    commentArray.forEach(msg => commentList.appendChild(createListElement(msg)));
  })
  .catch((error) => {
  console.error('Error:', error);
  });
}

function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}
