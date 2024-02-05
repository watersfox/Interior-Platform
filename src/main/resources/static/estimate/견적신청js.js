        // 각 카드의 버튼별 가격 설정
        const cardButtonPrices = {
            'Card 1': {
                'Button 1': 10000,
                'Button 2': 20000,
                'Button 3': 30000,
            },
            'Card 2': {
                'Button 1': 5000,
                'Button 2': 10000,
                'Button 3': 15000,
            },
            // 다른 카드들에 대해서도 버튼 가격을 설정해주세요
            // ...
        };

        let currentCardIndex = 1;
        //let currentButtonIndex = 1;
        let cardTotalPrices = {};

        function showCard(cardName) {
            const cardElement = document.getElementById('card');
            const checkboxGroupElement = document.getElementById('checkbox-group');

            // Clear existing checkbox items
            checkboxGroupElement.innerHTML = '';

            // Create checkbox items dynamically
            for (let i = 1; i <= 3; i++) {
                const checkboxItem = document.createElement('div');
                checkboxItem.classList.add('checkbox-item');

                const checkbox = document.createElement('input');
                checkbox.type = 'checkbox';
                checkbox.id = `checkbox${i}`;
                checkbox.addEventListener('change', updateNextButtonState);
                checkboxItem.appendChild(checkbox);

                const label = document.createElement('label');
                label.classList.add('checkbox-label');
                label.htmlFor = `checkbox${i}`;
                label.textContent = `Checkbox ${i}`;
                checkboxItem.appendChild(label);

                checkboxGroupElement.appendChild(checkboxItem);
            }

            // Update card title
            cardElement.querySelector('h2').textContent = cardName;

            // Initially hide Prev button if it's the first card
            document.getElementById('prev-btn').style.display = (currentCardIndex === 1) ? 'none' : 'block';
            // Adjust Next button width if it's the first card
            document.getElementById('next-btn').style.width = (currentCardIndex === 1) ? '300px' : '150px';
        }

function nextCard() {
    const progressBar = document.getElementById('progress-bar');
    const checkboxGroup = document.getElementById('checkbox-group');
    const prevBtn = document.getElementById('prev-btn');

    // Check if at least one checkbox is checked
    const checkboxes = checkboxGroup.querySelectorAll('input[type="checkbox"]');
    const atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

    if (!atLeastOneChecked) {
        alert('Please check at least one checkbox.');
        return;
    }

    // Calculate progress
    const progress = currentCardIndex * 10; // 각 카드에 10%씩 할당
    progressBar.style.width = `${progress}%`;

    // Show next card
    currentCardIndex++;

    // Enable prev button
    prevBtn.disabled = false;

    if (currentCardIndex <= 10) {
        const cardName = `Card ${currentCardIndex}`;
        showCard(cardName);
    } else {
        alert('All cards completed!');
        // Disable next button if all cards completed
        document.getElementById('next-btn').disabled = true;
    }

    // Disable next button after showing the next card
    document.getElementById('next-btn').disabled = true;
}

function prevCard() {
    const progressBar = document.getElementById('progress-bar');
    const checkboxGroup = document.getElementById('checkbox-group');
    const nextBtn = document.getElementById('next-btn');

    // Calculate progress
    currentCardIndex--;
    const progress = (currentCardIndex - 1) * 10;
    progressBar.style.width = `${progress}%`;

    // Show previous card
    const cardName = `Card ${currentCardIndex}`;
    showCard(cardName);

    // Enable next button
    nextBtn.disabled = false;

    // Disable prev button if at the first card
    if (currentCardIndex === 1) {
        document.getElementById('prev-btn').disabled = true;
    }
}

        function updateNextButtonState() {
            // Enable next button if at least one checkbox is checked
            const checkboxes = document.querySelectorAll('input[type="checkbox"]');
            const atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);
            document.getElementById('next-btn').disabled = !atLeastOneChecked;
        }

        // Initial setup
        showCard('Card 1');