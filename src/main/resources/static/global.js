document.addEventListener("DOMContentLoaded", function () {
  const bellbox = document.getElementById("bellbox");
  const notificationDropdown = document.getElementById("notification-dropdown");
  const bellBadge = document.getElementById("bell-badge");

  // 알림 개수 초기값 설정
  let notificationCount = 0;

  function toggleDropdown() {
    // 토글 형식으로 드롭다운 표시/숨김
    notificationDropdown.style.display = (notificationDropdown.style.display === "block") ? "none" : "block";
    
    // 알림이 표시되면 알림 개수 초기화 및 배지 업데이트
    if (notificationDropdown.style.display === "block") {
      notificationCount = 0;
      updateBellBadge();
    }
  }

  bellbox.addEventListener("click", function (event) {
    if (notificationCount > 0) {
      // 알림이 있을 때만 토글 동작
      toggleDropdown();
    }
    event.stopPropagation(); // 클릭 이벤트 전파를 막음
  });

  // 알림이 올 때마다 메뉴 추가 (예시)
  function addNotification(message) {
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
    });
    notificationDropdown.appendChild(notificationItem);

    // 알림 개수 업데이트 및 배지 업데이트
    notificationCount++;
    updateBellBadge();
  }

  // 예시: 5초마다 알림 추가
  setInterval(function () {
    const timestamp = new Date().toLocaleTimeString();
    addNotification("New notification at " + timestamp);
  }, 5000);

  // document에 클릭 이벤트 추가하여 드롭다운 닫기
  document.addEventListener("click", function () {
    notificationDropdown.style.display = "none";
  });

  // 초기에 알림이 없을 때 메시지 추가
  const noNotificationMessage = document.createElement("p");
  noNotificationMessage.textContent = "알림이 없습니다.";
  noNotificationMessage.addEventListener("click", function (event) {
    event.stopPropagation(); // 클릭 이벤트 전파를 막음
  });
  notificationDropdown.appendChild(noNotificationMessage);

  // 배지 업데이트 함수
  function updateBellBadge() {
    bellBadge.textContent = notificationCount > 9 ? '9+' : notificationCount;
    bellBadge.style.display = notificationCount > 0 ? 'block' : 'none';
  }

  // 초기에 배지 알림 숨김
  updateBellBadge();
});
