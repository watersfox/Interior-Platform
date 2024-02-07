document.addEventListener("DOMContentLoaded", function () {
  const bellbox = document.getElementById("bellbox");
  const notificationDropdown = document.getElementById("notification-dropdown");
  const bellBadge = document.getElementById("bell-badge");

  // 알림 개수 초기값 설정
  let notificationCount = 0;
  let Count = 0;

  // 전역으로 선언하여 한 번만 생성
  const noNotificationMessage = document.createElement("p");
  noNotificationMessage.textContent = "알림이 없습니다.";
  noNotificationMessage.addEventListener("click", function (event) {
    event.stopPropagation(); // 클릭 이벤트 전파를 막음
  });

  function toggleDropdown() {
    // 항상 토글 형식으로 드롭다운 표시/숨김
    notificationDropdown.style.display = (notificationDropdown.style.display === "block") ? "none" : "block";

    // 알림이 표시되면 알림 개수 초기화 및 배지 업데이트
    if (notificationDropdown.style.display === "block") {
      notificationCount = 0;
      updateBellBadge();
    }
  }

  bellbox.addEventListener("click", function (event) {
    // 알림 버튼을 누를 때 항상 토글 동작
    toggleDropdown();
    event.stopPropagation(); // 클릭 이벤트 전파를 막음
  });

  bellbox.addEventListener("click", function (event) {
    if (notificationCount > 0) {
      // 알림이 있을 때만 토글 동작
      toggleDropdown();
    }
    event.stopPropagation(); // 클릭 이벤트 전파를 막음
  });

  // 알림이 올 때마다 메뉴 추가 (예시)
  function addNotification(message) {
    Count++;
    if (notificationDropdown.contains(noNotificationMessage)) {
      // 알림이 추가되면서 "알림이 없습니다." 텍스트가 있을 경우 숨김
      notificationDropdown.removeChild(noNotificationMessage);
    }

    const notificationItem = document.createElement("a");
    notificationItem.href = "#";
    notificationItem.textContent = message;
    notificationItem.addEventListener("click", function (event) {
      event.stopPropagation(); // 클릭 이벤트 전파를 막음
      // 알림 메시지 클릭 시 원하는 동작 수행
      deleteNotification(notificationItem);
    });
    notificationDropdown.appendChild(notificationItem);

    // 드롭다운이 표시된 상태에서 알림이 추가되면 notificationCount를 0으로 초기화하고 업데이트
    if (notificationDropdown.style.display === "block") {
      notificationCount = 0;
      updateBellBadge();
    } else {
      // 드롭다운이 숨겨진 상태에서 알림이 추가되면 notificationCount 증가 및 업데이트
      notificationCount++;
      updateBellBadge();
    }
  }

  // 알림 메시지 삭제 함수
  function deleteNotification(notificationItem) {
    notificationDropdown.removeChild(notificationItem);
    Count--;
    // 알림 개수 업데이트 및 배지 업데이트
    updateBellBadge();

    if (Count === 0) {
      // 알림이 추가되면서 "알림이 없습니다." 텍스트가 있을 경우 숨김
      notificationDropdown.appendChild(noNotificationMessage);
    }
  }

  // 예시: 5초마다 알림 추가
  setInterval(function () {
    const timestamp = new Date().toLocaleTimeString();
    addNotification("신규 게시글이 작성됐습니다." + timestamp);
  }, 5000);

  // document에 클릭 이벤트 추가하여 드롭다운 닫기
  document.addEventListener("click", function () {
    notificationDropdown.style.display = "none";
  });

  // 초기에 알림이 없을 때 메시지 추가
  notificationDropdown.appendChild(noNotificationMessage);

  // 배지 업데이트 함수
  function updateBellBadge() {
    const badgeNumber = notificationCount > 9 ? '9+' : notificationCount;

    // 배지 텍스트 갱신
    bellBadge.textContent = ''; // 먼저 텍스트를 지워줍니다.

    // 스타일 적용
    bellBadge.innerHTML = '<span id="badge-text">' + badgeNumber + '</span>';
    const badgeText = document.getElementById("badge-text");
    badgeText.textContent = badgeNumber; // 직접 텍스트를 설정해줍니다.
    badgeText.style.marginLeft = '-3px'; // 원하는 만큼 조절하세요
    badgeText.style.marginTop = '-1px'; // 원하는 만큼 조절하세요
    badgeText.style.display = 'inline-block';
    bellBadge.style.display = notificationCount > 0 ? 'flex' : 'none'; // display를 flex로 변경
    bellBadge.style.alignItems = 'flex-start'; // 상단 정렬을 위해 align-items를 추가
  }

  // 초기에 배지 알림 숨김
  updateBellBadge();
});
