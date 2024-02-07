        let currentCardIndex = 1;
        //let currentButtonIndex = 1;
        let cardTotalPrices = {};
        
        let buildingType = null;
        let buildDate = null;
        let budget = null;
        let availableDate = null;
        let constructionType;
        let address = null;
        
function updateInputValue() {
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    const checkedCheckbox = Array.from(checkboxes).find(checkbox => checkbox.checked);

    if (checkedCheckbox) {
        buildingType = checkedCheckbox.nextElementSibling.textContent;
        if (currentCardIndex === 2) {
            buildDate = buildingType;
        } else if (currentCardIndex === 3) {
            budget = checkedCheckbox.nextElementSibling.textContent;
        }
    }
    
        // Update address
    if (currentCardIndex === 5) {
        const addressInput = document.getElementById('address-input');
        address = addressInput.value;
    }
}  

        function showCard(cardName) {
            const cardElement = document.getElementById('card');
            const checkboxGroupElement = document.getElementById('checkbox-group');

            // Clear existing checkbox items
            checkboxGroupElement.innerHTML = '';
            
                // Update card title based on the card index
    switch (currentCardIndex) {
        case 1:
            cardName = '건물 유형';
            createEstimateCheckboxes();
            break;
        case 2:
            cardName = '공사예정일';
            createEstimateCheckboxes();
            break;
        case 3:
            cardName = '인테리어 예산';
            createEstimateCheckboxes();
            break;
        case 4:
            cardName = '실측 가능일';
            showCalendar();
            break;
        case 5:
            cardName = '주소';
            showAddressInput();
            break;
            
		case 6:
            cardName = '';
            break;            
        default:
            break;
    }
            
            

        	 // Update card title
            cardElement.querySelector('h2').textContent = cardName;         
            
            // Initially hide Prev button if it's the first card
            document.getElementById('prev-btn').style.display = (currentCardIndex === 1) ? 'none' : 'block';
            // Adjust Next button width if it's the first card
            document.getElementById('next-btn').style.width = (currentCardIndex === 1) ? '300px' : '150px';            
        	
        	
			if (currentCardIndex < 4) {
        	createEstimateCheckboxes();  
        	}
        	
        	// Show input elements only for the fourth card
    		if (currentCardIndex === 4) {
        		showCalendar();
    		}        
    		if (currentCardIndex === 5) {
        		showAddressSelection();
    		}       
    		
    			 			             

        }

function nextCard() {
    const progressBar = document.getElementById('progress-bar');
    const checkboxGroup = document.getElementById('checkbox-group');
    const prevBtn = document.getElementById('prev-btn');
    const submitBtn = document.getElementById('submit-btn');
    const nextBtn = document.getElementById('next-btn');
    
    updateInputValue();
    
// Check if it's the fifth card and the address is selected
if (currentCardIndex === 5 && (availableAddress === null || availableAddress.trim() === '')) {
    alert('Please enter your address.');
    return;
} 
    
    // Check if it's the fourth card and the calendar date is selected
    if (currentCardIndex === 4 && availableDate === null) {
        alert('Please select a date.');
        return;
    }

    // Check if at least one checkbox is checked
    const checkboxes = checkboxGroup.querySelectorAll('input[type="checkbox"]');
    const atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

    if (!atLeastOneChecked && currentCardIndex < 4) {
        alert('Please check at least one checkbox.');
        return;
    }

    // Disable all checkboxes
    checkboxes.forEach(checkbox => {
        checkbox.disabled = true;
    });

    // Calculate progress
    const progress = currentCardIndex * 20; // 각 카드에 18%씩 할당
    progressBar.style.width = `${progress}%`;

    // Show next card
    currentCardIndex++;

    // Enable prev button
    prevBtn.disabled = false;

    if (currentCardIndex <= 6) {
        const cardName = `Card ${currentCardIndex}`;
        showCard(cardName);

        // Disable next button if at the last card
        if (currentCardIndex === 6) {
            nextBtn.disabled = true;
        }
    } else {
        alert('All cards completed!');
        // Disable next button if all cards completed
        nextBtn.disabled = true;

        // Show Submit button
        if (currentCardIndex === 7) {
            submitBtn.style.display = 'block';
        }
    }
    
    if (currentCardIndex <= 6) {
        const cardName = `Card ${currentCardIndex}`;
        showCard(cardName);

        // Hide next and prev buttons if it's the last card
        if (currentCardIndex === 6) {
			submit();
            nextBtn.style.display = 'none';
            prevBtn.style.display = 'none';
            // Show completion message
            const completionMessage = document.createElement('p');
            completionMessage.textContent = '견적서 작성이 완료되었습니다.';
            checkboxGroup.appendChild(completionMessage);
        }
    }    
}





function prevCard() {
    const progressBar = document.getElementById('progress-bar');
    const checkboxGroup = document.getElementById('checkbox-group');
    const nextBtn = document.getElementById('next-btn');
    const submitBtn = document.getElementById('submit-btn');

    // Calculate progress
    currentCardIndex--;
    const progress = (currentCardIndex - 1) * 10;
    progressBar.style.width = `${progress}%`;

    // Show previous card
    const cardName = `Card ${currentCardIndex}`;
    showCard(cardName);

    // Enable next button
    nextBtn.disabled = false;

    // Hide Submit button
    submitBtn.style.display = 'none';

    // Disable prev button if at the first card
    if (currentCardIndex === 1) {
        document.getElementById('prev-btn').disabled = true;
    }
    
        if (currentCardIndex === 1) {
        buildingType = null;
    }  
    if (currentCardIndex === 2) {
        buildDate = null;
    }       
    if (currentCardIndex === 3) {
        budget = null;
    }     
    if(currentCardIndex === 4){
		availableDate = null;
	}
    if (currentCardIndex === 5) {
        availableAddress = null;
    }	
}


        function updateNextButtonState() {
            // Enable next button if at least one checkbox is checked
            const checkboxes = document.querySelectorAll('input[type="checkbox"]');
            const atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);
            document.getElementById('next-btn').disabled = !atLeastOneChecked;
        }

function createEstimateCheckboxes() {
    const checkboxGroupElement = document.getElementById('checkbox-group');
    checkboxGroupElement.innerHTML = '';

    let options;
    if (currentCardIndex === 1) {
        options = ['아파트', '빌라', '주택', '오피스텔'];
    } else if (currentCardIndex === 2) {
        options = ['1개월 이내', '2개월 이내', '3개월 이내', '3개월 이후', '미정'];
    } else if (currentCardIndex === 3) {
        options = ['1천만원 미만', '1천만원대', '2천만원대', '3천만원대', '4천만원대', '5천만원 이상', '미정'];
    }
    
    options.forEach((option, index) => {
        const checkboxItem = document.createElement('div');
        checkboxItem.classList.add('checkbox-item');

        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.id = `checkbox${index + 1}`;
        checkbox.addEventListener('change', updateNextButtonState);
        checkboxItem.appendChild(checkbox);

        const label = document.createElement('label');
        label.classList.add('checkbox-label');
        label.htmlFor = `checkbox${index + 1}`;
        label.textContent = option;
        checkboxItem.appendChild(label);

        checkboxGroupElement.appendChild(checkboxItem);
    });
}

function showCalendar() {
    // 달력을 표시하고 사용자가 날짜를 선택할 수 있도록 설정하는 코드 작성
    const datePicker = document.createElement('input');
    datePicker.type = 'date';
    datePicker.id = 'date-picker';
    datePicker.addEventListener('change', function() {
        const selectedDate = datePicker.value;
        availableDate = selectedDate;
    });

    const checkboxGroupElement = document.getElementById('checkbox-group');
    checkboxGroupElement.innerHTML = '';
    checkboxGroupElement.appendChild(datePicker);
}

function showAddressSelection() {
    // 주소 선택을 위한 입력란을 생성합니다.
    const addressInput = document.createElement('input');
    addressInput.type = 'text';
    addressInput.placeholder = 'Enter your address';
    addressInput.id = 'address-input';

    // 주소 입력이 변경될 때마다 availableAddress 변수를 업데이트합니다.
    addressInput.addEventListener('input', function() {
        availableAddress = addressInput.value;
    });

    // 주소 입력란을 checkbox 그룹 요소 대신에 추가합니다.
    const checkboxGroupElement = document.getElementById('checkbox-group');
    checkboxGroupElement.innerHTML = '';
    checkboxGroupElement.appendChild(addressInput);
}

function showAddressInput() {
    // Address input field
    const addressInput = document.createElement('input');
    addressInput.type = 'text';
    addressInput.id = 'address-input';
    addressInput.placeholder = 'Enter your address';
    
    const checkboxGroupElement = document.getElementById('checkbox-group');
    checkboxGroupElement.innerHTML = '';
    checkboxGroupElement.appendChild(addressInput);
}

        // Initial setup
        showCard('Card 1');

function submit(){        
const estimateDTO = {
    buildingType: buildingType,
    buildDate: buildDate,
    budget: budget,
    availableDate: availableDate,
    address: address
};

// AJAX 요청을 사용하여 DTO 객체를 서버로 전송
fetch('/saveEstimate', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(estimateDTO)
})
.then(response => response.json())
.then(data => {
    console.log('Estimate saved:', data);
})
.catch(error => {
    console.error('Error saving estimate:', error);
});        
}        