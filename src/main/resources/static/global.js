document.addEventListener("DOMContentLoaded", function () {
  const bellbox = document.getElementById("bellbox");
  const notificationDropdown = document.getElementById("notification-dropdown");

  bellbox.addEventListener("click", function () {
    // 토글 형식으로 드롭다운 표시/숨김
    notificationDropdown.style.display = (notificationDropdown.style.display === "block") ? "none" : "block";
  });

  // 알림이 올 때마다 메뉴 추가 (예시)
  function addNotification(message) {
    const notificationItem = document.createElement("a");
    notificationItem.href = "#";
    notificationItem.textContent = message;
    notificationDropdown.appendChild(notificationItem);
  }

  // 예시: 5초마다 알림 추가
  setInterval(function () {
    const timestamp = new Date().toLocaleTimeString();
    addNotification("New notification at " + timestamp);
  }, 5000);
});
